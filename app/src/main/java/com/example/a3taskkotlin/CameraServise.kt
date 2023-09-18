package com.example.a3taskkotlin

import android.content.Context
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner

class CameraService(val preview: androidx.camera.core.Preview){

    private fun getImageCapture(): ImageCapture{
        return ImageCapture.Builder()
            .build()
    }
    private fun getCameraSelector(): CameraSelector{
        return CameraSelector.DEFAULT_BACK_CAMERA
    }
    fun startCamera(context: Context) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    context as LifecycleOwner, getCameraSelector(), preview, getImageCapture())

            } catch(exc: Exception) {
                Log.e("CameraService", "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(context))
    }
}