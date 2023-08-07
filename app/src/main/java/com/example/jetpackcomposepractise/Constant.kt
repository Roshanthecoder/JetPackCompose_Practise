package com.example.jetpackcomposepractise

import android.content.Context
import android.hardware.usb.UsbDevice.getDeviceId
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.compose.runtime.CompositionContext

val application = MyApplication.getMyApplication()
val DEVICE_NAME = Build.DEVICE + " " + Build.MODEL + " " + Build.MANUFACTURER
val DEVICE_ID = getDeviceId()

fun getDeviceId(): String {
    return Settings.Secure.getString(application.contentResolver, Settings.Secure.ANDROID_ID)
}

fun showToast(msg: String) {
    Toast.makeText(application, msg, Toast.LENGTH_LONG).show()
}

fun showToastShort(msg: String) {
    Toast.makeText(application, msg, Toast.LENGTH_SHORT).show()
}
