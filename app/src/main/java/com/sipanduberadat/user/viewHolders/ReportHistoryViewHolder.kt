package com.sipanduberadat.user.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sipanduberadat.user.R
import com.sipanduberadat.user.models.Pelaporan
import kotlinx.android.synthetic.main.layout_card_report_history.view.*
import java.util.*

class ReportHistoryViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(report: Pelaporan) {
        val calendar = Calendar.getInstance().apply {
            time = report.time
        }
        val datetimeText = "${calendar[Calendar.DAY_OF_MONTH].toString()
                .padStart(2, '0')}/${(calendar[Calendar.MONTH] + 1).toString()
                .padStart(2, '0')}/${calendar[Calendar.YEAR]} " +
                "${calendar[Calendar.HOUR_OF_DAY].toString().padStart(2, '0')}:" +
                "${calendar[Calendar.MINUTE].toString().padStart(2, '0')}:" +
                calendar[Calendar.SECOND].toString().padStart(2, '0')
        val reporter = "Pelapor: ${report.krama.name}"
        val emergencyStatus = if (report.jenisPelaporan.isEmergency) "Darurat" else "Keluhan"

        view.title.text = report.jenisPelaporan.name
        view.location.text = report.desaAdat.name
        view.datetime.text = datetimeText
        view.reporter.text = reporter

        view.report_emergency_status.text = emergencyStatus
        view.report_emergency_status.setChipBackgroundColorResource(
                if (report.jenisPelaporan.isEmergency) R.color.red_700 else R.color.blue)
        view.report_status.text = report.status
    }

}