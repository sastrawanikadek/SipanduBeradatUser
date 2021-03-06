package com.sipanduberadat.user.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sipanduberadat.user.R
import com.sipanduberadat.user.models.Krama
import com.sipanduberadat.user.viewHolders.FamilyViewHolder

class FamilyRecyclerAdapter(
    private val context: Context,
    private val items: List<Krama>
): RecyclerView.Adapter<FamilyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_family, parent,
            false)
        return FamilyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.onBindItem(items[position])
    }

}