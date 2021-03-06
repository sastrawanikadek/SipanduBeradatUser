package com.sipanduberadat.user.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sipanduberadat.user.R
import com.sipanduberadat.user.models.*
import com.sipanduberadat.user.viewHolders.ReportHistoryViewHolder
import java.util.*

class ReportHistoryRecyclerAdapter(
        private val context: Context
): RecyclerView.Adapter<ReportHistoryViewHolder>() {

    private val items: List<Pelaporan> = listOf(
        Pelaporan(1, Krama(1, Banjar(1, DesaAdat(1, Kelurahan(1,
            Kecamatan(1, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true), "Gianyar", true), "Sukawati", true),
            "Batuan", true), "Batuan Kaler", (0).toDouble(), (0).toDouble(),
            true), "Gede", true), "Made Gede Gunung", "test.png", "08123",
            Calendar.getInstance().time, "51030123323", "Laki-laki", "Krama Wid",
            true, true), DesaAdat(1, Kelurahan(1, Kecamatan(1, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true),
            "Gianyar", true), "Sukawati", true), "Batuan", true), "Batuan Kaler", (0).toDouble(), (0).toDouble(),
            true), JenisPelaporan(1, "Tornado", "tornado.png", true), Calendar.getInstance().time,
            (0).toDouble(), (0).toDouble(), "Menunggu Pecalang"),
        Pelaporan(2, Krama(2, Banjar(2, DesaAdat(2, Kelurahan(2,
            Kecamatan(2, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true), "Gianyar", true), "Blahbatuh", true),
            "Batuh", true), "Pering", (0).toDouble(), (0).toDouble(),
            true), "Tojan", true), "I Ketut Sandal", "test2.png", "081234345456",
            Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
            true, true), DesaAdat(2, Kelurahan(2, Kecamatan(2, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true),
            "Gianyar", true), "Blahbatuh", true), "Batuh", true), "Pering", (0).toDouble(), (0).toDouble(),
            true), JenisPelaporan(2, "Kecelakaan", "kecelakaan.png", true), Calendar.getInstance().time,
            (0).toDouble(), (0).toDouble(), "Menunggu Validasi"),
        Pelaporan(3, Krama(3, Banjar(3, DesaAdat(3, Kelurahan(3,
            Kecamatan(3, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true), "Gianyar", true), "Gianyar", true),
            "Serongga", true), "Serongga", (0).toDouble(), (0).toDouble(),
            true), "Serongga kelod", true), "I Made Madya", "test3.png", "081234345456",
            Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
            true, true), DesaAdat(3, Kelurahan(3, Kecamatan(3, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true),
            "Gianyar", true), "Gianyar", true), "Serongga", true), "Serongga", (0).toDouble(), (0).toDouble(),
            true), JenisPelaporan(3, "Jalan Rusak", "jalanrusak.png", false), Calendar.getInstance().time,
            (0).toDouble(), (0).toDouble(), "Sedang Ditangani"),
        Pelaporan(4, Krama(4, Banjar(4, DesaAdat(4, Kelurahan(4,
            Kecamatan(4, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true), "Gianyar", true), "Tampaksiring", true),
            "Pejeng", true), "Pejeng Kelod", (0).toDouble(), (0).toDouble(),
            true), "Delod Pangkung", true), "I Gusti Putra", "test4.png", "081234345456",
            Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
            true, true), DesaAdat(4, Kelurahan(4, Kecamatan(4, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true),
            "Gianyar", true), "Tampaksiring", true), "Pejeng", true), "Pejeng Kelod", (0).toDouble(), (0).toDouble(),
            true), JenisPelaporan(4, "Kebakaran", "kebakaran.png", true), Calendar.getInstance().time,
            (0).toDouble(), (0).toDouble(), "Selesai"),
        Pelaporan(5, Krama(5, Banjar(5, DesaAdat(5, Kelurahan(5,
            Kecamatan(5, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true), "Gianyar", true), "Tegalalang", true),
            "Kedisan", true), "Kedisan", (0).toDouble(), (0).toDouble(),
            true), "Kedisan Kelod", true), "I Wayan Numbrag", "test5.png", "081234345456",
            Calendar.getInstance().time, "5104012873660001", "Laki-laki", "Krama Wid",
            true, true), DesaAdat(5, Kelurahan(5, Kecamatan(5, Kabupaten(1, Provinsi(1, Negara(1, "Indonesia", true), "Bali", true),
            "Gianyar", true), "Tegalalang", true), "Kedisan", true), "Kedisan", (0).toDouble(), (0).toDouble(),
            true), JenisPelaporan(5, "Pohon Tumbang", "pohontumbang.png", false), Calendar.getInstance().time,
            (0).toDouble(), (0).toDouble(), "Tidak Valid")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportHistoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_card_report_history, parent,
                false)
        return ReportHistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ReportHistoryViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

}