package com.sipanduberadat.user.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sipanduberadat.user.fragments.EmergencyFragment
import com.sipanduberadat.user.fragments.NewsFragment
import com.sipanduberadat.user.fragments.ProfileFragment
import com.sipanduberadat.user.fragments.ReportHistoryFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments: List<Fragment> = listOf(
            EmergencyFragment(),
            ReportHistoryFragment(),
            NewsFragment(),
            ProfileFragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}