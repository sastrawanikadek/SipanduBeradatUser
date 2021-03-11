package com.sipanduberadat.user.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.activity_choose_report_location.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class ChooseReportLocationActivity : AppCompatActivity() {

    private lateinit var map: GoogleMap
    private lateinit var location: Location

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_report_location)
        setSupportActionBar(top_app_bar_toolbar)

        location = intent.getParcelableExtra("LOCATION") as Location

        top_app_bar_title.text = getString(R.string.ubah_lokasi)
        top_app_bar_btn_back.setOnClickListener { finish() }

        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment)
                as SupportMapFragment
        mapFragment.getMapAsync {
            map = it
            map.isMyLocationEnabled = true
            map.uiSettings.isMyLocationButtonEnabled = true

            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(location.latitude, location.longitude),
                    14.0f))

            var marker: Marker = map.addMarker(MarkerOptions().position(LatLng(location.latitude,
                location.longitude)))

            map.setOnMapClickListener { latlng ->
                marker.remove()
                location.latitude = latlng.latitude
                location.longitude = latlng.longitude
                marker = map.addMarker(MarkerOptions().position(LatLng(location.latitude,
                    location.longitude)))
            }
        }

        btn_save.setOnClickListener {
            val intent = Intent()
            intent.putExtra("LOCATION", location)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}