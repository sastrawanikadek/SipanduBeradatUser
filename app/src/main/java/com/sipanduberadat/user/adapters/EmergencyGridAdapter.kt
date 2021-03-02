package com.sipanduberadat.user.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.sipanduberadat.user.R
import com.sipanduberadat.user.models.JenisPelaporan
import kotlinx.android.synthetic.main.layout_grid_emergency.view.*

class EmergencyGridAdapter(private val context: Context): BaseAdapter() {

    private val emergencyButtons: List<JenisPelaporan> = listOf(
            JenisPelaporan(1, "Kebakaran",
                    "https://www.freeiconspng.com/thumbs/flame-png/fire-vector-icon-png-27.png",
                    true),
            JenisPelaporan(2, "Tsunami",
                    "https://img.icons8.com/plasticine/2x/tsunami.png",
                    true),
            JenisPelaporan(1, "Kebakaran",
                    "https://www.freeiconspng.com/thumbs/flame-png/fire-vector-icon-png-27.png",
                    true),
            JenisPelaporan(2, "Tsunami",
                    "https://img.icons8.com/plasticine/2x/tsunami.png",
                    true),
            JenisPelaporan(1, "Kebakaran",
                    "https://www.freeiconspng.com/thumbs/flame-png/fire-vector-icon-png-27.png",
                    true),
            JenisPelaporan(2, "Tsunami",
                    "https://img.icons8.com/plasticine/2x/tsunami.png",
                    true),
            JenisPelaporan(1, "Kebakaran",
                    "https://www.freeiconspng.com/thumbs/flame-png/fire-vector-icon-png-27.png",
                    true),
            JenisPelaporan(2, "Tsunami",
                    "https://img.icons8.com/plasticine/2x/tsunami.png",
                    true),
            JenisPelaporan(1, "Kebakaran",
                    "https://www.freeiconspng.com/thumbs/flame-png/fire-vector-icon-png-27.png",
                    true),
            JenisPelaporan(2, "Tsunami",
                    "https://img.icons8.com/plasticine/2x/tsunami.png",
                    true)
    )

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1 ?: LayoutInflater.from(context).inflate(R.layout.layout_grid_emergency, p2,
                false)
        Glide.with(context).load(emergencyButtons[p0].icon).fitCenter().into(view.grid_item_icon)
        view.grid_item_name.text = emergencyButtons[p0].name
        return view
    }

    override fun getItem(p0: Int): Any {
        return emergencyButtons[p0]
    }

    override fun getItemId(p0: Int): Long {
        return emergencyButtons[p0].id
    }

    override fun getCount(): Int {
        return emergencyButtons.size
    }

}