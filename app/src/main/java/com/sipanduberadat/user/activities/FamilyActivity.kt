package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sipanduberadat.user.R
import com.sipanduberadat.user.adapters.FamilyRecyclerAdapter
import com.sipanduberadat.user.models.*
import kotlinx.android.synthetic.main.activity_family.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*
import java.util.*

class FamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.kerabat)
        top_app_bar_btn_back.setOnClickListener { finish() }

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@FamilyActivity, LinearLayoutManager.VERTICAL,
                false)
            adapter = FamilyRecyclerAdapter(this@FamilyActivity, listOf(
                Krama(1, Banjar(1, DesaAdat(1, Kecamatan(1, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true),
                    "Bali", true), "Gianyar", true), "Sukawati", true), "Batuan Kaler", (0).toDouble(), (0).toDouble(),
                    true), "Gede", true), "Made Gede Gunung", "https://1.bp.blogspot.com/-oIdHWQIe0lY/Vt7KVnjR7WI/AAAAAAAAAUo/1whO1HjqUYs/s320/Contoh%2BPas%2BFoto.png", "08123",
                    Calendar.getInstance().time, "51030123323", "Laki-laki", "Krama Wid",
                    true, true),
                Krama(2, Banjar(2, DesaAdat(2, Kecamatan(2, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true),
                    "Bali", true), "Gianyar", true), "Blahbatuh", true), "Pering", (0).toDouble(), (0).toDouble(),
                    true), "Tojan", true), "I Ketut Sandal", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTE30a-qEnZ-jWR-qELPJBUVZ7ayuTAuerXoQ&usqp=CAU", "081234345456",
                    Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
                    true, true),
                Krama(3, Banjar(3, DesaAdat(3, Kecamatan(3, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true),
                    "Bali", true), "Gianyar", true), "Gianyar", true), "Serongga", (0).toDouble(), (0).toDouble(),
                    true), "Serongga kelod", true), "I Made Madya", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlzXvml2sfkFAYzzbVly02LUNE8AsV7td0BA&usqp=CAU", "081234345456",
                    Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
                    true, true),
                Krama(4, Banjar(4, DesaAdat(4, Kecamatan(4, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true),
                    "Bali", true), "Gianyar", true), "Tampaksiring", true), "Pejeng Kelod", (0).toDouble(), (0).toDouble(),
                    true), "Delod Pangkung", true), "I Gusti Putra", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhDjHunqssoiR15ZZfa92yC_OaojUWRUKzXw&usqp=CAU", "081234345456",
                    Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
                    true, true),
                Krama(5, Banjar(5, DesaAdat(5, Kecamatan(5, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true),
                    "Bali", true), "Gianyar", true), "Tegalalang", true), "Kedisan", (0).toDouble(), (0).toDouble(),
                    true), "Kedisan Kelod", true), "I Wayan Numbrag", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSn--t2V6MSKptPmmbb9GFPJMtmfM1ihrREIQ&usqp=CAU", "081234345456",
                    Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
                    true, true)
            ))
        }

        btn_add.setOnClickListener {
            val intent = Intent(this, AddFamilyActivity::class.java)
            startActivity(intent)
        }
    }

}