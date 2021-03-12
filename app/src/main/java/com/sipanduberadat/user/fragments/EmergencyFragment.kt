package com.sipanduberadat.user.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.sipanduberadat.user.R
import com.sipanduberadat.user.adapters.EmergencyRecyclerAdapter
import com.sipanduberadat.user.models.JenisPelaporan
import kotlinx.android.synthetic.main.fragment_emergency.view.*

class EmergencyFragment: Fragment() {

    private val emergencyButtons: List<JenisPelaporan> = listOf(
        JenisPelaporan(1, "Kebakaran",
            "https://www.freeiconspng.com/thumbs/flame-png/fire-vector-icon-png-27.png",
            true),
        JenisPelaporan(2, "Tsunami",
            "https://img.icons8.com/plasticine/2x/tsunami.png",
            true),
        JenisPelaporan(3, "Gempa",
            "https://img.icons8.com/office/2x/earthquakes.png",
            true),
        JenisPelaporan(4, "Pencurian",
            "https://image.flaticon.com/icons/png/128/10/10925.png",
            true),
        JenisPelaporan(5, "Longsor",
            "https://image.flaticon.com/icons/png/128/2910/2910054.png",
            true),
        JenisPelaporan(6, "Kecelakaan",
            "https://image.flaticon.com/icons/png/128/2125/2125190.png",
            true),
        JenisPelaporan(7, "Hewan Liar",
            "https://image.flaticon.com/icons/png/128/1447/1447876.png",
            true),
        JenisPelaporan(8, "Pohon Tumbang",
            "https://image.flaticon.com/icons/png/128/1973/1973230.png",
            true),
        JenisPelaporan(9, "Banjir",
            "https://image.flaticon.com/icons/png/128/3217/3217150.png",
            true)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view =  inflater.inflate(R.layout.fragment_emergency, container, false)
        val flexboxLayoutManager = FlexboxLayoutManager(activity).apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.SPACE_EVENLY
            flexWrap = FlexWrap.WRAP
        }

        view.recycler_view.apply {
            layoutManager = flexboxLayoutManager
            adapter = EmergencyRecyclerAdapter(activity!!, emergencyButtons)
        }

        return view
    }

}