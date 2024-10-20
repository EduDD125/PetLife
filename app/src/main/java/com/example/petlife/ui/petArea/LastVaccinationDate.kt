package com.example.petlife.ui.petArea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.petlife.R
import com.example.petlife.databinding.ActivityLastVaccinationDateBinding

class LastVaccinationDate : AppCompatActivity() {
    private val lvda: ActivityLastVaccinationDateBinding by lazy {
        ActivityLastVaccinationDateBinding.inflate(layoutInflater)
    }
    private lateinit var lastVaccination: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(lvda.root)

        // Receber a data da última vacinação
        intent.getStringExtra("last_vaccination_date_edit")?.also { date ->
            lastVaccination = date
            lvda.petLastVaccinationEt.setText(lastVaccination)
        }

        // Botão de salvar
        lvda.saveEditBt.setOnClickListener {
            lastVaccination = lvda.petLastVaccinationEt.text.toString()
            Intent().apply {
                putExtra("back_from_edit_vaccination_date", lastVaccination)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}