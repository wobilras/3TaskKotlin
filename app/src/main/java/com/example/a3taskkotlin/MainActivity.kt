package com.example.a3taskkotlin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import com.example.a3taskkotlin.databinding.MainActivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //CoroutineScope(Dispatchers.IO).launch {
        //    initMassiveArray()
        //}
        if (checkCameraPermission() and checkStoragePermission()){
            CameraService(getPreview()).startCamera(this)
        }
        val btnShot: Button = findViewById(R.id.btn_take_photo)
        btnShot.setOnClickListener {
            saveCurrentDateTime()
        }
        binding.buttonList.setOnClickListener {
            val intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)
        }
    }
    private fun checkCameraPermission(): Boolean {
        return if(checkSelfPermission(Manifest.permission.CAMERA) ==
            PackageManager.PERMISSION_GRANTED) {
            true
        } else {
            requestPermissions(arrayOf(Manifest.permission.CAMERA), 1)
            false
        }
    }

    private fun checkStoragePermission(): Boolean {
        return if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
            PackageManager.PERMISSION_GRANTED) {
            true
        } else {
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            false
        }
    }

    private fun getPreview(): Preview {
        return Preview.Builder()
            .build()
            .also {
                it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
            }
    }

    private fun saveCurrentDateTime() {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        val dateTime = Date()
        val dateTimeString = dateFormat.format(dateTime)
        val file = File(
            getExternalFilesDir("photos"),
            "date.txt"
        )
        file.appendText("$dateTimeString\n")
    }

    fun initMassiveArray(){
        val array = arrayOfNulls<Int>(1000000)
        array.forEach { println(it) }
    }
}