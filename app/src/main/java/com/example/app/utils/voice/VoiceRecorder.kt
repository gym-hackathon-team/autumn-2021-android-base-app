package com.example.app.utils.voice

import java.io.IOException
import java.util.concurrent.TimeUnit
import android.media.MediaRecorder
import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.File

class VoiceRecorder(private val filesDir: File) {
    private var recorder: MediaRecorder? = null
    fun startRecording() {
        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setOutputFile(File(filesDir, "test.mp4").absolutePath)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                prepare()
            } catch (e: IOException) {
                Log.e("VoiceRecognition", "prepare() failed")
            }

            start()
        }
    }

    private var message: String = ""
    fun stopRecording() {
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
        Thread {
            val client = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build()
            val requestBody = MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(
                "upload_file",
                "test.mp4",
                RequestBody.create(
                    "audio/mp4".toMediaTypeOrNull(),
                    File(filesDir, "test.mp4")
                )
            ).build()
            val request =
                Request.Builder().url("http://5.63.154.19:8088/recognize").post(requestBody).build()
            val call =
                client.newBuilder().build().newCall(request);

            val response = call.execute()
            message = response.body!!.string()
            if (response.isSuccessful) {
                // TODO: Use message
            } else {
                // TODO: Handle error from server, located in message
            }
        }.start()
    }
}