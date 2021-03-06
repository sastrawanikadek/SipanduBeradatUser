package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.data_diri)
        top_app_bar_btn_back.setOnClickListener { finish() }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_change_name -> onChangeActivity(UpdateNameActivity::class.java)
            R.id.btn_change_gender -> onChangeActivity(UpdateGenderActivity::class.java)
        }
    }

    private fun onChangeActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

}