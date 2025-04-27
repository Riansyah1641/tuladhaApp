package com.thesis.tuladhaapp.ui.detailCourse.player

import androidx.lifecycle.DefaultLifecycleObserver

interface PlayerManager : DefaultLifecycleObserver {
    fun play(videoUrl: String, onFullScreenListener: (Boolean) -> Unit)

    fun release()
}
