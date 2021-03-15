package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_add_family.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class AddFamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_family)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.pencarian_kerabat)
        top_app_bar_btn_back.setOnClickListener { finish() }

        username_edit_text.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                val intent = Intent(this, ProfileNotFoundActivity::class.java)
                startActivity(intent)
                return@setOnEditorActionListener true
            }
            false
        }
    }

}