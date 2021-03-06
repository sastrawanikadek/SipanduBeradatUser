package com.sipanduberadat.user.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatDelegate
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_splash_screen.*
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences = getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)

        if (!sharedPreferences.contains("DAY_NIGHT")) {
            val editor = sharedPreferences.edit()
            editor.putInt("DAY_NIGHT", AppCompatDelegate.MODE_NIGHT_NO)
            editor.apply()
        }

        AppCompatDelegate.setDefaultNightMode(sharedPreferences.getInt("DAY_NIGHT",
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM))

        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        logo.startAnimation(animation)

        Timer().schedule(2000) {
            val intent = Intent(this@SplashScreenActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}