package com.example.petlife.ui.petArea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.petlife.R
import com.example.petlife.databinding.ActivityLastVetDateBinding

class LastVetDate : AppCompatActivity() {

    private val lvda: ActivityLastVetDateBinding by lazy {
        ActivityLastVetDateBinding.inflate(layoutInflater)
    }

    private lateinit var lastVetVisit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(lvda.root)

        intent.getStringExtra("last_vet_visit_date_edit")?.also { date ->
            lastVetVisit = date
            lvda.petLastVetVisitEt.setText(lastVetVisit)
        }

        lvda.saveEditBt.setOnClickListener {
            lastVetVisit = lvda.petLastVetVisitEt.text.toString()
            Intent().apply {
                putExtra("back_from_edit_vet_visit_date", lastVetVisit)
                setResult(RESULT_OK, this)
            }
            finish()
        }

        lvda.cancelEditBt.setOnClickListener {
            Intent().apply {
                putExtra("back_from_edit_petshop_visit_date", lastVetVisit)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}