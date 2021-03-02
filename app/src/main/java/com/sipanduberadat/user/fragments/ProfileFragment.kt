package com.sipanduberadat.user.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sipanduberadat.user.R
import com.sipanduberadat.user.activities.ProfileActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment: Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.btn_profile.setOnClickListener { onChangeActivity(ProfileActivity::class.java) }
        view.btn_logout.setOnClickListener { onLogout() }

        return view
    }

    private fun onChangeActivity(cls: Class<*>) {
        val intent = Intent(activity, cls)
        activity?.startActivity(intent)
    }

    private fun onLogout() {
        activity?.finish()
    }

}