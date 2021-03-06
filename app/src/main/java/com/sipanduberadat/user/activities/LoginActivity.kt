package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.sipanduberadat.user.R
import com.sipanduberadat.user.utils.snackbarWarning
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.masuk)
        top_app_bar_btn_back.setOnClickListener { finish() }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_login -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.btn_register -> handleToRegister()
        }
    }

    private fun handleLogin() {
        val username = "${nama_pengguna_edit_text.text}"
        val password = "${kata_sandi_edit_text.text}"

        if (username.isNotBlank() && password.isNotBlank()) {
            return
        }

        snackbarWarning(wrapper, "Nama pengguna dan kata sandi tidak boleh kosong",
            Snackbar.LENGTH_LONG).show()
    }

    private fun handleToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }

}