package com.sipanduberadat.user.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.layout_dialog_term_condition.*

class TermConditionDialog(private val ctx: Context): Dialog(ctx) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dialog_term_condition)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        btn_accept.setTextColor(ContextCompat.getColor(ctx, android.R.color.darker_gray))
        term_condition_switch.setOnCheckedChangeListener { _, b ->
            btn_accept.isEnabled = b
            btn_accept.setTextColor(ContextCompat.getColor(ctx,
                    if (b) R.color.white else android.R.color.darker_gray))
        }
    }

}