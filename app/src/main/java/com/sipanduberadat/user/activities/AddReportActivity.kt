package com.sipanduberadat.user.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.bumptech.glide.Glide
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_add_report.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class AddReportActivity : AppCompatActivity() {

    private lateinit var map: GoogleMap
    private lateinit var location: Location
    private lateinit var marker: Marker

    @SuppressLint("MissingPermission", "VisibleForTests")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_report)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.pengajuan_keluhan)
        top_app_bar_btn_back.setOnClickListener { finish() }

        btn_change_location.setOnClickListener {
            val intent = Intent(this, ChooseReportLocationActivity::class.java)
            intent.putExtra("LOCATION", location)
            startActivityForResult(intent, 3)
        }
        btn_change_photo.setOnClickListener { onChangePhoto() }

        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment)
                as SupportMapFragment
        mapFragment.getMapAsync { map = it }

        FusedLocationProviderClient(this).lastLocation.addOnSuccessListener {
            location = it
            initMap()
        }
    }

    private fun onChangePhoto() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val intentChooser = Intent.createChooser(galleryIntent, "Pilih sumber foto")
        intentChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))
        startActivityForResult(intentChooser, 2)
    }

    @SuppressLint("MissingPermission")
    private fun initMap() {
        map.uiSettings.apply {
            isZoomControlsEnabled = false
            isZoomGesturesEnabled = false
            isMyLocationButtonEnabled = false
            isScrollGesturesEnabled = false
            isScrollGesturesEnabledDuringRotateOrZoom = false
        }

        map.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(location.latitude, location.longitude),
            14.0f))

        if (this::marker.isInitialized) {
            marker.remove()
        }

        marker = map.addMarker(MarkerOptions().position(LatLng(location.latitude, location.longitude)))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                if (requestCode == 2) {
                    if (data.data != null) {
                        val uri = data.data
                        Glide.with(this).load(uri).centerCrop().into(photo_image_view)
                        return
                    }

                    val bitmap = data.extras!!.get("data") as Bitmap
                    Glide.with(this).load(bitmap).centerCrop().into(photo_image_view)
                } else if (requestCode == 3) {
                    location = data.getParcelableExtra("LOCATION") as Location
                    initMap()
                }
            }
        }
    }

}