package com.sipanduberadat.user.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sipanduberadat.user.R
import com.sipanduberadat.user.activities.AddReportActivity
import com.sipanduberadat.user.adapters.ReportHistoryRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_report_history.view.*

class ReportHistoryFragment: Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_report_history, container, false)

        view.recycler_view.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,
                    false)
            adapter = ReportHistoryRecyclerAdapter(activity!!)
        }

        view.btn_add.setOnClickListener {
            val intent = Intent(activity, AddReportActivity::class.java)
            activity!!.startActivity(intent)
        }

        return view
    }

}