package com.sipanduberadat.user.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sipanduberadat.user.R
import com.sipanduberadat.user.adapters.ReportHistoryRecyclerAdapter
import kotlinx.android.synthetic.main.activity_profile_other.*

class ProfileOtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_other)
        btn_back.setOnClickListener { finish() }

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@ProfileOtherActivity,
                    LinearLayoutManager.VERTICAL, false)
            adapter = ReportHistoryRecyclerAdapter(this@ProfileOtherActivity)
        }
    }

}