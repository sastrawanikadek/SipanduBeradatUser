package com.sipanduberadat.user.activities

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat
import androidx.viewpager.widget.ViewPager
import com.sipanduberadat.user.R
import com.sipanduberadat.user.adapters.MainViewPagerAdapter
import com.sipanduberadat.user.utils.checkPermissions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_btn_back.visibility = View.GONE
        top_app_bar_title.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { setMargins(0, 0, 0, 0) }
        top_app_bar_title.text = getString(R.string.pelaporan_darurat)

        if (!checkPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.CAMERA))) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.CAMERA
                ), 1
            )
        }

        view_pager.adapter = MainViewPagerAdapter(supportFragmentManager)

        bottom_app_bar_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.emergency -> {
                    top_app_bar_title.text = getString(R.string.pelaporan_darurat)
                    view_pager.currentItem = 0
                }
                R.id.report_history -> {
                    top_app_bar_title.text = getString(R.string.riwayat_pelaporan)
                    view_pager.currentItem = 1
                }
                R.id.timeline -> {
                    top_app_bar_title.text = getString(R.string.lini_masa)
                    view_pager.currentItem = 2
                }
                R.id.profile -> {
                    top_app_bar_title.text = getString(R.string.profil)
                    view_pager.currentItem = 3
                }
            }
            true
        }

        view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float,
                                        positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottom_app_bar_navigation.selectedItemId = R.id.emergency
                    1 -> bottom_app_bar_navigation.selectedItemId = R.id.report_history
                    2 -> bottom_app_bar_navigation.selectedItemId = R.id.timeline
                    3 -> bottom_app_bar_navigation.selectedItemId = R.id.profile
                }
            }
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    finish()
                }
            }
        }
    }

}