package com.sipanduberadat.user.viewHolders

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sipanduberadat.user.activities.ProfileOtherActivity
import com.sipanduberadat.user.models.Krama
import kotlinx.android.synthetic.main.layout_item_family.view.*

class FamilyViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun onBindItem(family: Krama) {
        val location = "Banjar ${family.banjar.name}, Desa ${family.banjar.desaAdat.name}"

        Glide.with(view.context).load(family.avatar).fitCenter().into(view.item_avatar)
        view.item_name.text = family.name
        view.item_location.text = location
        view.item_phone.text = family.phone

        view.container.setOnClickListener {
            val intent = Intent(view.context, ProfileOtherActivity::class.java)
            view.context.startActivity(intent)
        }
    }

}