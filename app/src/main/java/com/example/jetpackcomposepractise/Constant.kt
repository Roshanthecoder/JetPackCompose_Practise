package com.example.jetpackcomposepractise

import android.os.Build
import android.provider.Settings
import android.widget.Toast

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
