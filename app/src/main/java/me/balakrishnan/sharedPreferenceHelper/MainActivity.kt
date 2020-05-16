package me.balakrishnan.sharedPreferenceHelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val preferenceHelper = PreferenceHelper(this)
        preferenceHelper.userID = Int.MAX_VALUE
        preferenceHelper.userLoggedIn = true
        preferenceHelper.userName = "Droid Log"
        Log.d(TAG, String.format(" %s %d %b", preferenceHelper.userName, preferenceHelper.userID, preferenceHelper.userLoggedIn))
    }
}
