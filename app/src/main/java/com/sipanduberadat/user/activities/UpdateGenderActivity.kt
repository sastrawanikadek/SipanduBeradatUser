package com.sipanduberadat.user.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_update_gender.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class UpdateGenderActivity : AppCompatActivity() {

    private var selectedGender = "l"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_gender)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.ubah_jenis_kelamin)
        top_app_bar_btn_back.setOnClickListener { finish() }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.male_image_view -> onSelectGender("l")
            R.id.female_image_view -> onSelectGender("p")
        }
    }

    private fun onSelectGender(gender: String) {
        selectedGender = gender

        if (gender == "l") {
            female_image_view.setImageResource(R.drawable.ic_female_grayscale)
            male_image_view.setImageResource(R.drawable.ic_male)
        } else {
            male_image_view.setImageResource(R.drawable.ic_male_grayscale)
            female_image_view.setImageResource(R.drawable.ic_female)
        }
    }

}