package com.sipanduberadat.user.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sipanduberadat.user.R
import com.sipanduberadat.user.activities.FamilyActivity
import com.sipanduberadat.user.activities.LocationActivity
import com.sipanduberadat.user.activities.ProfileActivity
import com.sipanduberadat.user.activities.UpdatePasswordActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment: Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var viewLayout: View

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewLayout = inflater.inflate(R.layout.fragment_profile, container, false)
        sharedPreferences = activity!!.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)

        viewLayout.btn_daynight.setImageResource(if (AppCompatDelegate.getDefaultNightMode() ==
            AppCompatDelegate.MODE_NIGHT_NO) R.drawable.ic_moon else R.drawable.ic_sun)

        viewLayout.btn_profile.setOnClickListener { onChangeActivity(ProfileActivity::class.java) }
        viewLayout.btn_location.setOnClickListener { onChangeActivity(LocationActivity::class.java) }
        viewLayout.btn_family.setOnClickListener { onChangeActivity(FamilyActivity::class.java) }
        viewLayout.btn_change_password.setOnClickListener { onChangeActivity(UpdatePasswordActivity::class.java) }
        viewLayout.btn_logout.setOnClickListener { onLogout() }
        viewLayout.btn_daynight.setOnClickListener { onToggleDayNight() }
        viewLayout.circle_image_view.setOnClickListener { onChoosePhoto() }
        viewLayout.fab_image.setOnClickListener { onChoosePhoto() }

        return viewLayout
    }

    private fun onChangeActivity(cls: Class<*>) {
        val intent = Intent(activity, cls)
        activity?.startActivity(intent)
    }

    private fun onLogout() {
        activity?.finish()
    }

    private fun onToggleDayNight() {
        val dayNightmode = if (AppCompatDelegate.getDefaultNightMode() ==
            AppCompatDelegate.MODE_NIGHT_NO) AppCompatDelegate.MODE_NIGHT_YES else
            AppCompatDelegate.MODE_NIGHT_NO

        val editor = sharedPreferences.edit()
        editor.putInt("DAY_NIGHT", dayNightmode)
        editor.apply()

        AppCompatDelegate.setDefaultNightMode(dayNightmode)
        viewLayout.btn_daynight.setImageResource(if (dayNightmode == AppCompatDelegate.MODE_NIGHT_NO)
            R.drawable.ic_moon else R.drawable.ic_sun)
    }

    private fun onChoosePhoto() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val intentChooser = Intent.createChooser(galleryIntent, "Pilih sumber foto")
        intentChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))
        startActivityForResult(intentChooser, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                if (data.data != null) {
                    val uri = data.data
                    Glide.with(activity!!).load(uri).centerCrop().into(viewLayout.circle_image_view)
                    return
                }

                val bitmap = data.extras!!.get("data") as Bitmap
                Glide.with(activity!!).load(bitmap).centerCrop().into(viewLayout.circle_image_view)
            }
        }
    }

}