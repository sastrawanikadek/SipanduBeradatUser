package com.sipanduberadat.user.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class UpdateNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_name)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.ubah_nama_lengkap)
        top_app_bar_btn_back.setOnClickListener { finish() }
    }

}