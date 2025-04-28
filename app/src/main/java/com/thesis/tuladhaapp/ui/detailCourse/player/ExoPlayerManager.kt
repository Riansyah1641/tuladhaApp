package com.thesis.tuladhaapp.ui.detailCourse.player

import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import kotlin.math.max

class ExoPlayerManager(private val playerView: PlayerView) : PlayerManager {

    private var player: ExoPlayer? = null
    private var startAutoPlay = false
    private var startItemIndex = 0
    private var startPosition: Long = 0
    private var currentMediaItem: MediaItem? = null

    // Fungsi untuk memutar video
    private fun play(mediaItem: MediaItem?, haveStartPosition: Boolean = false) {
        currentMediaItem = mediaItem
        currentMediaItem?.let {
            player?.playWhenReady = startAutoPlay
            player?.setMediaItem(it, !haveStartPosition)
            player?.prepare()
        }
    }

    // Inisialisasi ExoPlayer
    private fun initializePlayer(onFullScreenListener: (Boolean) -> Unit) {
        if (player == null) {
            player = ExoPlayer.Builder(playerView.context)
                .build()
                .also { exoPlayer ->
                    exoPlayer.trackSelectionParameters = exoPlayer.trackSelectionParameters
                        .buildUpon()
                        .setMaxVideoSizeSd()
                        .build()
                    playerView.setFullscreenButtonClickListener { isFullScreen ->
                        onFullScreenListener(isFullScreen)
                    }
                    playerView.player = exoPlayer
                }
        }

        val haveStartPosition = startItemIndex != C.INDEX_UNSET
        if (haveStartPosition) {
            player?.seekTo(startItemIndex, startPosition)
        }
        play(currentMediaItem, haveStartPosition)
    }

    // Fungsi utama untuk memutar video
    override fun play(videoUrl: String, onFullScreenListener: (Boolean) -> Unit) {
        // Memastikan player sudah siap
        if (player == null) {
            initializePlayer(onFullScreenListener)
        }

        // Buat MediaItem dari URL video
        val mediaItem = MediaItem.fromUri(videoUrl)

        // Mainkan video
        play(mediaItem, false)
    }

    // Fungsi untuk melepaskan player
    override fun release() {
        releasePlayer()
    }

    private fun updateIndex() {
        player?.let {
            startAutoPlay = it.playWhenReady
            startItemIndex = it.currentMediaItemIndex
            startPosition = max(0, it.contentPosition)
        }
    }

    private fun clearIndex() {
        startAutoPlay = true
        startItemIndex = C.INDEX_UNSET
        startPosition = C.TIME_UNSET
    }

    private fun releasePlayer() {
        player?.let { exoPlayer ->
            updateIndex()
            exoPlayer.release()
            player = null
            currentMediaItem = null
            playerView.player = null
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        clearIndex()
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        playerView.onResume()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        playerView.onPause()
        releasePlayer()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        playerView.onPause()
        releasePlayer()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        playerView.onResume()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        releasePlayer()

    }
}
