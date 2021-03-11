package com.sipanduberadat.user.viewHolders

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sipanduberadat.user.R
import com.sipanduberadat.user.activities.DetailReportActivity
import com.sipanduberadat.user.models.JenisPelaporan
import kotlinx.android.synthetic.main.layout_item_emergency.view.*

class EmergencyViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun onBindItem(jenisPelaporan: JenisPelaporan, pos: Int, isLast: Boolean = false) {
        Glide.with(view.context).load(jenisPelaporan.icon).fitCenter().into(view.item_icon)
        view.item_name.text = jenisPelaporan.name

        val lp = view.container.layoutParams
        if (lp is FlexboxLayoutManager.LayoutParams) {
            lp.apply {
                lp.flexGrow = 1.0f

                if (pos % 3 != 1 || isLast) {
                    marginStart = 0
                    marginEnd = 0
                }
            }
        }

        view.container.setOnClickListener {
            MaterialAlertDialogBuilder(view.context)
                    .setTitle(jenisPelaporan.name)
                    .setMessage(R.string.konfirmasi_pelaporan_darurat)
                    .setNegativeButton(R.string.batal) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.lanjutkan) { dialog, _ ->
                        val intent = Intent(view.context, DetailReportActivity::class.java)
                        view.context.startActivity(intent)
                        dialog.dismiss()
                    }.show()
        }
    }

}