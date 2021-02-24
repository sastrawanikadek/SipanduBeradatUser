package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var autoCompleteLayouts: Array<TextInputLayout>
    private lateinit var autoCompletes: Array<AutoCompleteTextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.daftar_akun)
        top_app_bar_btn_back.setOnClickListener { finish() }

        autoCompleteLayouts = arrayOf(kabupaten_input_layout,
                kecamatan_input_layout, desa_adat_input_layout, banjar_input_layout)
        autoCompletes = arrayOf(kabupaten_auto_complete,
                kecamatan_auto_complete, desa_adat_auto_complete, banjar_auto_complete)

        for (i in autoCompletes.indices) {
            if (i > 0) {
                autoCompleteLayouts[i].visibility = View.GONE
            }
        }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_login -> handleToLogin()
            R.id.btn_register -> handleRegister()
        }
    }

    private fun handleToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleRegister() {
        return
    }

}