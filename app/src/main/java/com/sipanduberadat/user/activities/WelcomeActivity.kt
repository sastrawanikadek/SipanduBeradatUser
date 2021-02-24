package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.sipanduberadat.user.R
import com.sipanduberadat.user.adapters.WelcomeViewPagerAdapter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private val images: Array<Int> = arrayOf(R.drawable.ic_laporan_darurat,
        R.drawable.ic_laporan_keluhan, R.drawable.ic_notif_kerabat)
    private val titles: Array<String> = arrayOf("Laporan Darurat", "Laporan Keluhan",
        "Notifikasi Kerabat")
    private val descriptions: Array<String> = arrayOf(
        "Keamanan terjamin, laporkan keadaan darurat Anda hanya dengan menekan 1 tombol darurat",
        "Ajukan laporan keluhan Anda agar pihak berwenang dapat menindaklanjuti laporan keluhan Anda",
        "Dapatkan notifikasi pelaporan darurat yang dikirimkan oleh kerabat Anda"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        view_pager.adapter = WelcomeViewPagerAdapter(this, images, titles, descriptions)
        view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                handleChangeIndicator()
            }

        })
        handleChangeIndicator(true)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_login -> handleToActivity(LoginActivity::class.java)
            R.id.btn_register -> handleToActivity(RegisterActivity::class.java)
        }
    }

    private fun handleToActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

    private fun handleChangeIndicator(initial: Boolean = false) {
        for (i in images.indices) {
            val imageView = if (initial) ImageView(this) else view_pager_dot_wrapper[i]
                    as ImageView
            val drawable = ContextCompat.getDrawable(this,
                if (i == view_pager.currentItem) R.drawable.active_dot_indicator else
                    R.drawable.inactive_dot_indicator)
            val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                if (i == view_pager.currentItem) 50 else 25, 25
            )
            layoutParams.setMargins(8, 0, 8, 0)

            imageView.apply {
                setImageDrawable(drawable)
                setLayoutParams(layoutParams)
            }

            if (initial) {
                view_pager_dot_wrapper.addView(imageView)
            }
        }
    }
}