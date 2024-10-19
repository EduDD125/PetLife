package com.example.petlife.ui.petArea

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.petlife.R
import com.example.petlife.databinding.ActivityPetAreaBinding
import com.example.petlife.domain.model.Pet

class PetAreaActivity : AppCompatActivity() {
    private val paa: ActivityPetAreaBinding by lazy {
        ActivityPetAreaBinding.inflate(layoutInflater)
    }

    private var pet: Pet = Pet("", "", "", "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(paa.root)

        setSupportActionBar(paa.customToolbar.customToolbar)
        supportActionBar?.apply {
        }

        intent.getParcelableExtra<Pet>("pet_info")?.also { pet ->
            paa.petNameTextTv.text = pet.name
            paa.petSizeTextTv.text = pet.size
            paa.petColorTextTv.text = pet.color
            paa.petTypeTextTv.text = pet.type
            paa.petBirthDateTextTv.text = pet.birthDate
            paa.petPetshopVisitTextTv.text = pet.lastPetshopVisit
            paa.petVeterinarianVisitTextTv.text = pet.lastVetVisit
            paa.petLastVaccinationTextTv.text = pet.lastVaccination
        }
    }
}