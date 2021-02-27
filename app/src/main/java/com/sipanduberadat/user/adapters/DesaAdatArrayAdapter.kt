package com.sipanduberadat.user.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.textview.MaterialTextView
import com.sipanduberadat.user.R
import com.sipanduberadat.user.models.DesaAdat

class DesaAdatArrayAdapter(
        private val ctx: Context,
        private val items: List<DesaAdat>,
        private val resourceId: Int = R.layout.layout_list_item
): ArrayAdapter<DesaAdat>(ctx, resourceId, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(ctx).inflate(resourceId, parent,
                false)
        view.findViewById<MaterialTextView>(R.id.item_text_view).text = items[position].name
        return view
    }

    override fun getItem(position: Int): DesaAdat? {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return items[position].id
    }

}