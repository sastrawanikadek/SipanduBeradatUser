package com.sipanduberadat.user.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout
import com.sipanduberadat.user.R
import com.sipanduberadat.user.adapters.BanjarArrayAdapter
import com.sipanduberadat.user.adapters.DesaAdatArrayAdapter
import com.sipanduberadat.user.adapters.KabupatenArrayAdapter
import com.sipanduberadat.user.adapters.KecamatanArrayAdapter
import com.sipanduberadat.user.dialogs.TermConditionDialog
import com.sipanduberadat.user.models.Banjar
import com.sipanduberadat.user.models.DesaAdat
import com.sipanduberadat.user.models.Kabupaten
import com.sipanduberadat.user.models.Kecamatan
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_top_app_bar.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var autoCompleteLayouts: Array<TextInputLayout>
    private lateinit var autoCompletes: Array<AutoCompleteTextView>
    private var kabupatens: List<Kabupaten> = listOf()
    private var kecamatans: List<Kecamatan> = listOf()
    private var desaAdats: List<DesaAdat> = listOf()
    private var banjars: List<Banjar> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(top_app_bar_toolbar)

        top_app_bar_title.text = getString(R.string.daftar_akun)
        top_app_bar_btn_back.setOnClickListener { finish() }

        autoCompleteLayouts = arrayOf(kabupaten_input_layout,
                kecamatan_input_layout, desa_adat_input_layout, banjar_input_layout)
        autoCompletes = arrayOf(kabupaten_auto_complete,
                kecamatan_auto_complete, desa_adat_auto_complete, banjar_auto_complete)

        for (i in autoCompletes.indices) {
            autoCompletes[i].setOnItemClickListener { adapterView, _, pos, _ ->
                val selectedId = adapterView.getItemIdAtPosition(pos)

                for (j in i + 1 until autoCompletes.size) {
                    autoCompleteLayouts[j].visibility = View.GONE
                    autoCompletes[j].setText("")

                    if (j == i + 1) {
                        when (j) {
                            1 -> autoCompletes[j].setAdapter(KecamatanArrayAdapter(this,
                                    kecamatans.filter { it.kabupaten.id == selectedId }))
                            2 -> autoCompletes[j].setAdapter(DesaAdatArrayAdapter(this,
                                    desaAdats.filter { it.kecamatan.id == selectedId }))
                            3 -> autoCompletes[j].setAdapter(BanjarArrayAdapter(this,
                                    banjars.filter { it.desaAdat.id == selectedId }))
                        }
                        autoCompleteLayouts[j].visibility = View.VISIBLE
                    }
                }
            }
        }

        onResponseKabupaten()
        onResponseKecamatan()
        onResponseDesaAdat()
        onResponseBanjar()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_login -> onToLogin()
            R.id.btn_register -> onRegister()
        }
    }

    private fun onToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun onRegister() {
        TermConditionDialog(this).show()
        return
    }

    private fun onResponseKabupaten() {
        kabupatens = listOf(
                Kabupaten(1, "Badung", true),
                Kabupaten(2, "Denpasar", true)
        )

        kabupaten_auto_complete.setAdapter(KabupatenArrayAdapter(this, kabupatens))
    }

    private fun onResponseKecamatan() {
        kecamatans = listOf(
                Kecamatan(1, kabupatens[0], "Abiansemal", true),
                Kecamatan(2, kabupatens[0], "Mengwi", true),
                Kecamatan(3, kabupatens[1], "Denpasar Utara", true)
        )
    }

    private fun onResponseDesaAdat() {
        desaAdats = listOf(
                DesaAdat(1, kecamatans[0], "Abiansemal", 0.0, 0.0,
                        true),
                DesaAdat(2, kecamatans[0], "Angantaka", 0.0, 0.0,
                        true),
                DesaAdat(3, kecamatans[1], "Mengwitani", 0.0, 0.0,
                        true)
        )
    }

    private fun onResponseBanjar() {
        banjars = listOf(
                Banjar(1, desaAdats[0], "Gunung", true),
                Banjar(2, desaAdats[1], "Dalem", true)
        )
    }

}