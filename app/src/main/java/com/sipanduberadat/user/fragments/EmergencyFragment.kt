package com.sipanduberadat.user.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sipanduberadat.user.R
import com.sipanduberadat.user.adapters.EmergencyGridAdapter
import kotlinx.android.synthetic.main.fragment_emergency.view.*

class EmergencyFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view =  inflater.inflate(R.layout.fragment_emergency, container, false)

        view.grid_view.adapter = EmergencyGridAdapter(activity!!)

        return view
    }

}