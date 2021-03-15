package com.sipanduberadat.user.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_profile_not_found.*

class ProfileNotFoundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_not_found)
        btn_back.setOnClickListener { finish() }
    }

}