package com.sipanduberadat.user.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sipanduberadat.user.R
import com.sipanduberadat.user.models.Pelaporan
import com.sipanduberadat.user.utils.Constants
import kotlinx.android.synthetic.main.activity_detail_report.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*
import java.util.*

class DetailReportActivity : AppCompatActivity() {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_report)
        setSupportActionBar(top_app_bar_toolbar)

        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_circle_mini)!!
        val report: Pelaporan = intent.getParcelableExtra("REPORT") as Pelaporan
        val calendar = Calendar.getInstance().apply {
            time = report.time
        }
        val datetimeText = "${calendar[Calendar.DAY_OF_MONTH].toString().padStart(2, '0')} " +
                "${Constants.MONTH_NAMES[calendar[Calendar.MONTH]]} " +
                "${calendar[Calendar.YEAR]} " +
                "${calendar[Calendar.HOUR_OF_DAY].toString().padStart(2, '0')}:" +
                "${calendar[Calendar.MINUTE].toString().padStart(2, '0')}:" +
                calendar[Calendar.SECOND].toString().padStart(2, '0')

        report_type.text = report.jenisPelaporan.name
        report_reporter.text = report.krama.name
        report_status.text = report.status
        report_datetime.text = datetimeText

        when (report.status) {
            "Menunggu Validasi" -> {
                drawable.setTint(ContextCompat.getColor(this, R.color.yellow))
                report_status.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null)
            }
            "Sedang Ditangani" -> {
                drawable.setTint(ContextCompat.getColor(this, R.color.blue))
                report_status.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null)
            }
            "Selesai" -> {
                drawable.setTint(ContextCompat.getColor(this, R.color.green))
                report_status.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null)
            }
            "Tidak Valid" -> {
                drawable.setTint(ContextCompat.getColor(this, R.color.black))
                report_status.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null)
            }
            else -> {
                drawable.setTint(ContextCompat.getColor(this, android.R.color.darker_gray))
                report_status.setCompoundDrawablesWithIntrinsicBounds(drawable, null,
                    null, null)
            }
        }

        if (!report.jenisPelaporan.isEmergency) {
            container_report_description.visibility = View.VISIBLE
            container_report_photo.visibility = View.VISIBLE
            report_description.text = report.description
            Glide.with(this).load(report.photo).centerCrop().into(report_photo)
        }

        top_app_bar_title.text = getString(R.string.detail_laporan)
        top_app_bar_btn_back.setOnClickListener { finish() }
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment)
                as SupportMapFragment
        mapFragment.getMapAsync {
            map = it
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(report.latitude, report.longitude),
                    14.0f))
            map.addMarker(
                MarkerOptions().position(
                    LatLng(report.latitude,
                        report.longitude)
                ))
        }
    }

}