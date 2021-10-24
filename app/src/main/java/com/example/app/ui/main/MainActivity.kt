package com.example.app.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.media.AudioRecord
import androidx.core.os.postDelayed
import android.media.MediaRecorder
import android.os.Handler
import android.view.MotionEvent
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.viewModel
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.ui.base.BaseActivity
import com.example.app.ui.payments_list.PaymentsListFragment
import com.example.domain.entities.Command
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.lang.Exception

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()

    override fun getBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onStart() {
        super.onStart()
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_content_main
        ) as NavHostFragment
        views.bottomNavigationView.setupWithNavController(navHostFragment.navController)
        setupActionBarWithNavController(navHostFragment.navController)

        views.bRecord.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    startAudioRecord()
                }
                MotionEvent.ACTION_UP -> {
                    stopAudioRecord()
                }
            }
            view.performClick()
            true
        }

    }

    override fun setupListeners() {
        viewModel.observeViewEvents {
            when (it) {
                is MainActivityViewEvents.PerformCommand -> performCommand(it)
            }
        }
    }

    private fun performCommand(it: MainActivityViewEvents.PerformCommand) {
        when (it.it.voiceCommand) {
            Command.ORGANIZATION_PAYMENT,
            Command.USER_TRANSACTION -> {
                views.bottomNavigationView.selectedItemId = R.id.nav_payments
                Handler().postDelayed(500L) {
                    try {
                        val fragment = (supportFragmentManager.fragments[0].childFragmentManager.fragments[0] as PaymentsListFragment)
                        fragment.performCommand(it.it.voiceCommand)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            null -> Unit
        }
    }

    var mediaRecorder: MediaRecorder? = null
    var file: File? = null

    fun startAudioRecord() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                listOf(Manifest.permission.RECORD_AUDIO).toTypedArray(), 1
            )
            return
        }
        val externalDir = getExternalFilesDir(null)?.absolutePath.toString()
        file = File("${externalDir}${File.separator}${System.currentTimeMillis()}.mp4")
        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.DEFAULT)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setAudioEncodingBitRate(24000)
            setAudioSamplingRate(48000)
            setOutputFile(file?.absolutePath)
            prepare()
            start()
        }
    }

    fun stopAudioRecord() {
        mediaRecorder?.apply {
            stop()
            release()
        }
        mediaRecorder = null
        viewModel.sendFile(file)
    }

}