package com.example.app.ui.blank

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.airbnb.mvrx.fragmentViewModel
import com.example.app.databinding.FragmentTemplateBinding
import com.example.app.ui.base.BaseFragment
import java.io.File
import java.lang.Exception


class TemplateFragment : BaseFragment<FragmentTemplateBinding>()  {

    override val viewModel: TemplateViewModel by fragmentViewModel()

    override fun setupListeners() {
        views.bContinue.setOnTouchListener { view, motionEvent ->
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
        viewModel.observeViewEvents {
            when (it) {
                TemplateFragmentViewEvents.ShowToast -> Toast.makeText(requireContext(), "Голос зарегистрирован", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getBinding(): FragmentTemplateBinding {
        return FragmentTemplateBinding.inflate(layoutInflater)
    }

    var mediaRecorder: MediaRecorder? = null
    var file: File? = null

    fun startAudioRecord() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                listOf(Manifest.permission.RECORD_AUDIO).toTypedArray(), 1
            )
            return
        }
        val externalDir = requireContext().getExternalFilesDir(null)?.absolutePath.toString()
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
        try {
            mediaRecorder?.apply {
                stop()
                release()
            }
            mediaRecorder = null
            viewModel.sendFile(file)
        } catch (e: Exception) {
            mediaRecorder?.release()
            mediaRecorder = null
            e.printStackTrace()
        }
    }

}
