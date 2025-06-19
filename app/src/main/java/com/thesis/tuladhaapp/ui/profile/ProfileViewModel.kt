package com.thesis.tuladhaapp.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.thesis.tuladhaapp.model.firebase.ChildData
import com.thesis.tuladhaapp.repository.userRepository.UserRepository
import kotlinx.coroutines.Dispatchers

class ProfileViewModel(private val repo: UserRepository): ViewModel() {
    val isEditMode = MutableLiveData(false)
    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("childData")
    // LiveData untuk status operasi (opsional, untuk memberikan feedback ke UI)
    private val _operationStatus = MutableLiveData<String>()
    val operationStatus: LiveData<String> = _operationStatus

    // LiveData untuk daftar anak yang dibaca dari database
    private val _childrenList = MutableLiveData<List<ChildData>>()
    val childrenList: LiveData<List<ChildData>> = _childrenList

    fun changeEditMode() {
        val currentValue = isEditMode.value ?: false
        isEditMode.postValue(!currentValue)
    }

    fun changeProfile(fullName: String, uri: String) = repo.updateProfile(fullName, uri).asLiveData(Dispatchers.IO)

    fun changePassword() {
        repo.requestChangePasswordByEmail()
    }

    fun getCurrentUser() = repo.getCurrentUser()

    fun isUserLoggedIn() = repo.isLoggedIn()

    fun doLogout() {
        repo.doLogout()
    }

    fun addChildData(child: ChildData) {
        val userId = getCurrentUser()?.id
        if (userId == null) {
            _operationStatus.postValue("Error: User not logged in.")
            return
        }

        val childrenRef = database.child(userId).child("children") // Path: childData/{userId}/children
        val newChildRef = childrenRef.push() // Buat ID unik
        val childId = newChildRef.key // Dapatkan ID unik yang digenerate

        // Pastikan ID anak di model juga terisi
        child.id = childId

        newChildRef.setValue(child)
            .addOnSuccessListener {
                _operationStatus.postValue("Data anak '${child.name}' berhasil disimpan!")
                Log.d("ProfileViewModel", "Child data saved: ${child.name}")
                // Opsional: Setelah menyimpan, baca ulang data untuk update LiveData
                readAllChildrenData()
            }
            .addOnFailureListener { e ->
                _operationStatus.postValue("Gagal menyimpan data: ${e.message}")
                Log.e("ProfileViewModel", "Error saving child data: ${e.message}")
            }
    }

    fun readAllChildrenData() {
        val userId = getCurrentUser()?.id
        if (userId == null) {
            _operationStatus.postValue("Error: User not logged in.")
            _childrenList.postValue(emptyList()) // Kosongkan daftar jika tidak login
            return
        }

        val childrenRef = database.child(userId).child("children")
        childrenRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val childrenList = mutableListOf<ChildData>()
                if (snapshot.exists()) {
                    for (childSnapshot in snapshot.children) {
                        val child = childSnapshot.getValue(ChildData::class.java)
                        child?.let {
                            // Pastikan ID anak dari snapshot juga diambil jika belum ada di model
                            if (it.id == null) it.id = childSnapshot.key
                            childrenList.add(it)
                        }
                    }
                }
                _childrenList.postValue(childrenList) // Update LiveData
                _operationStatus.postValue("Data anak berhasil dimuat (${childrenList.size} anak).")
                Log.d("ProfileViewModel", "Children data loaded: ${childrenList.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                _operationStatus.postValue("Gagal memuat data anak: ${error.message}")
                Log.e("ProfileViewModel", "Error loading children data: ${error.message}")
                _childrenList.postValue(emptyList())
            }
        })
    }

    fun updateChildData(child: ChildData) {
        val userId = getCurrentUser()?.id
        if (userId == null) {
            _operationStatus.postValue("Error: User not logged in.")
            return
        }
        if (child.id == null) {
            _operationStatus.postValue("Error: Child ID is null for update.")
            return
        }

        val childRef = database.child(userId).child("children").child(child.id!!)
        childRef.setValue(child) // Menggunakan setValue untuk memperbarui seluruh objek
            .addOnSuccessListener {
                _operationStatus.postValue("Data anak '${child.name}' berhasil diperbarui!")
                Log.d("ProfileViewModel", "Child data updated: ${child.name}")
                // Opsional: Setelah update, baca ulang data
                readAllChildrenData()
            }
            .addOnFailureListener { e ->
                _operationStatus.postValue("Gagal memperbarui data: ${e.message}")
                Log.e("ProfileViewModel", "Error updating child data: ${e.message}")
            }

    }

    fun deleteChildData(childId: String) {
        val userId = getCurrentUser()?.id
        if (userId == null) {
            _operationStatus.postValue("Error: User not logged in.")
            return
        }

        val childRef = database.child(userId).child("children").child(childId)
        childRef.removeValue()
            .addOnSuccessListener {
                _operationStatus.postValue("Data anak dengan ID '$childId' berhasil dihapus!")
                Log.d("ProfileViewModel", "Child data deleted: $childId")
                // Opsional: Setelah delete, baca ulang data
                readAllChildrenData()
            }
            .addOnFailureListener { e ->
                _operationStatus.postValue("Gagal menghapus data: ${e.message}")
                Log.e("ProfileViewModel", "Error deleting child data: ${e.message}")
            }
    }
}