package com.example.sehaticapstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.sehaticapstoneproject.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    private var delay = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(
                this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delay)
    }
}