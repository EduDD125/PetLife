package com.example.petlife.ui.petArea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.petlife.R
import com.example.petlife.databinding.ActivityLastPestshopDateBinding

class LastPetshopDate : AppCompatActivity() {
    private val lpda: ActivityLastPestshopDateBinding by lazy {
        ActivityLastPestshopDateBinding.inflate(layoutInflater)
    }
    private lateinit var lastPetshopVisit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(lpda.root)

        intent.getStringExtra("last_petshop_visit_date_edit")?.also { date ->
            lastPetshopVisit = date
            lpda.petLastPetshopVisitEt.setText(lastPetshopVisit)
        }

        lpda.saveEditBt.setOnClickListener {
            lastPetshopVisit = lpda.petLastPetshopVisitEt.text.toString()
            Intent().apply {
                putExtra("back_from_edit_petshop_visit_date", lastPetshopVisit)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}