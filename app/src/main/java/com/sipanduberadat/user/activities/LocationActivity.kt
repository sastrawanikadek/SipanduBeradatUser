package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_location.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.alamat)
        top_app_bar_btn_back.setOnClickListener { finish() }

        btn_change.setOnClickListener {
            val intent = Intent(this, UpdateLocationActivity::class.java)
            startActivity(intent)
        }
    }

}