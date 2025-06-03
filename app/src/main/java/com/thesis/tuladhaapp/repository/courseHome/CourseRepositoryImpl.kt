package com.thesis.tuladhaapp.repository.courseHome

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.thesis.tuladhaapp.data.dataSource.DataSourceDetailCourse.DataSourceDetailCourse
import com.thesis.tuladhaapp.data.dataSource.course.DataSourceCourse
import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.model.detailcourse.CourseData
import com.thesis.tuladhaapp.model.detailcourse.CourseDetailData
import com.thesis.tuladhaapp.utils.ResultWrapper
import com.thesis.tuladhaapp.utils.proceedFlow
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class CourseRepositoryImpl(
    private val dataSource: DataSourceCourse,
    private val dataSourceDetailCourse: DataSourceDetailCourse
) : CourseRepository {
    private val database = FirebaseDatabase.getInstance().getReference("user_courses")

    override fun getCourses(
        search: String?,
        type: String?,
        category: Int?,
        level: String?,
        sortBy: String?
    ): Flow<ResultWrapper<List<Course>>> {
        return proceedFlow {
            dataSource.getCourses(search, type, category, level, sortBy) ?: emptyList()
        }
    }

    override fun getCoursesClass(
        search: String?,
        type: String?,
        category: List<Int>?,
        level: List<String>?,
        sortBy: String?
    ): Flow<ResultWrapper<List<Course>>> {
        return proceedFlow {
            dataSource.getCoursesClass(search, type, category, level, sortBy) ?: emptyList()
        }
    }

    override fun getDetailCourse(id: Int): Flow<ResultWrapper<CourseData?>> {
        return proceedFlow {
            dataSourceDetailCourse.getDetailCourse(id)
        }
    }

    override suspend fun sendCourseDataToFirebase(courseData: CourseData, idUser: String): Boolean {
        return try {
            val courseIdToSend = courseData.courseId?.toString() ?: return false
            val courseRef = database.child(idUser).child(courseIdToSend)

            // Periksa apakah progress sudah "Selesai" di database
            val isAlreadyDone = suspendCancellableCoroutine<Boolean> { continuation ->
                courseRef.child("progress").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val progress = snapshot.getValue(String::class.java)
                        continuation.resume(progress == "Selesai")
                    }

                    override fun onCancelled(error: DatabaseError) {
                        continuation.resumeWithException(Exception(error.message))
                    }
                })
                continuation.invokeOnCancellation {
                    // Optional: Handle cancellation if needed
                }
            }

            if (isAlreadyDone) {
                Log.d(
                    "Firebase Send",
                    "Course $courseIdToSend for user $idUser is already marked as 'Selesai'. Skipping update."
                )
                return true // Tidak ada error, hanya tidak ada update
            } else {
                // Lakukan update karena progress belum "Selesai"
                courseRef.setValue(courseData).await()
                Log.d(
                    "Firebase Send",
                    "Data kursus $courseIdToSend untuk pengguna $idUser berhasil dikirim/diupdate."
                )
                return true
            }

        } catch (e: Exception) {
            Log.e("Firebase Send Error", "Gagal mengirim/mengupdate data kursus: ${e.message}")
            false
        }
    }


    override fun getUserCourses(userId: String): Flow<List<CourseData>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Repository", "Snapshot Key (level): ${snapshot.key}")
                Log.d("Repository", "onDataChange dipanggil untuk user $userId")
                val courseList = mutableListOf<CourseData>()

                Log.d("Repository", "Jumlah child di bawah user $userId adalah ${snapshot.childrenCount}")

                for (courseIdSnapshot in snapshot.children) {
                    val enrollmentId = courseIdSnapshot.key // Gunakan key snapshot sebagai enrollmentId
                    Log.d("Repository", "Memproses enrollment dengan ID: $enrollmentId")

                    try {
                        val createAtGet = courseIdSnapshot.child("createdAt").getValue(String::class.java)
                        val accessible = courseIdSnapshot.child("accessible").getValue(Boolean::class.java)
                        val courseSnapshot = courseIdSnapshot.child("course")
                        val lastSeenGet = courseIdSnapshot.child("lastSeen").getValue(String::class.java)
                        val progressPercentageGet = courseIdSnapshot.child("progressPercentage").getValue(Int::class.java)
                        val followingGet = courseIdSnapshot.child("following").getValue(Boolean::class.java)
                        val progressGet = courseIdSnapshot.child("progress").getValue(String::class.java)
                        val updateAtGet = courseIdSnapshot.child("updatedAt").getValue(String::class.java)
                        val categorySnapshot = courseIdSnapshot.child("category")
                        val courseDetail = if (courseSnapshot.exists()) {
                            CourseDetailData(
                                id = courseSnapshot.child("id").getValue(Int::class.java),
                                name = courseSnapshot.child("name").getValue(String::class.java),
                                imageUrl = courseSnapshot.child("imageUrl").getValue(String::class.java),
                                videoPreviewUrl = courseSnapshot.child("videoPreviewUrl").getValue(String::class.java),
                                level = courseSnapshot.child("level").getValue(String::class.java),
                                rating = courseSnapshot.child("rating").getValue(Double::class.java),
                                categoryId = courseSnapshot.child("categoryId").getValue(Int::class.java),
                                description = courseSnapshot.child("description").getValue(String::class.java),
                                classCode = courseSnapshot.child("classCode").getValue(String::class.java),
                                totalModule = courseSnapshot.child("totalModule").getValue(Int::class.java),
                                totalDuration = courseSnapshot.child("totalDuration").getValue(Int::class.java),
                                type = courseSnapshot.child("type").getValue(String::class.java),
                                price = courseSnapshot.child("price").getValue(Int::class.java),
                                promo = courseSnapshot.child("promo").getValue(Int::class.java),
                                totalUser = courseSnapshot.child("totalUser").getValue(Int::class.java),
                                courseBy = courseSnapshot.child("courseBy").getValue(String::class.java),
                                createdBy = courseSnapshot.child("createdBy").getValue(Int::class.java),
                                createdAt = courseSnapshot.child("createdAt").getValue(String::class.java),
                                updatedAt = categorySnapshot.child("name").getValue(String::class.java),
                                category = null,
                                courseCreator = null,
                                benefits = null, // Handle benefits manually jika perlu
                                chapters = null // Handle chapters manually jika perlu
                            )
                        } else {
                            null
                        }

                        val courseData = CourseData(
                            isAccessible = accessible,
                            course = courseDetail,
                            id = enrollmentId?.toIntOrNull(), // Gunakan enrollmentId sebagai ID
                            courseId = enrollmentId?.toIntOrNull(),
                            isFollowing = followingGet,
                            lastSeen = lastSeenGet,
                            progress = progressGet,
                            progressPercentage = progressPercentageGet,
                            createdAt = createAtGet,
                            updatedAt = updateAtGet,
                            userId = userId
                        )
                        courseList.add(courseData)
                    } catch (e: Exception) {
                        Log.e("Repository", "Error processing enrollment $enrollmentId: ${e.message}")
                    }
                }

                Log.d("Repository", "Jumlah kursus yang akan di-emit adalah ${courseList.size}")
                trySend(courseList).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Repository", "Error saat mengambil data kursus: ${error.message}", error.toException())
                close(error.toException())
            }
        }

        database.child(userId).addValueEventListener(listener)
        awaitClose { database.child(userId).removeEventListener(listener) }
    }
}
