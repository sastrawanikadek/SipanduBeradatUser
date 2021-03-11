package com.sipanduberadat.user.activities

import android.annotation.SuppressLint
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class DetailReportActivity : AppCompatActivity() {

    private lateinit var map: GoogleMap
    private lateinit var location: Location

    @SuppressLint("MissingPermission", "VisibleForTests")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_report)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.detail_laporan)
        top_app_bar_btn_back.setOnClickListener { finish() }
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment)
                as SupportMapFragment
        mapFragment.getMapAsync {
            map = it
        }

        FusedLocationProviderClient(this).lastLocation.addOnSuccessListener {
            location = it
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(location.latitude, location.longitude),
                    14.0f))
            map.addMarker(
                MarkerOptions().position(
                    LatLng(location.latitude,
                        location.longitude)
                ))
        }
    }

}