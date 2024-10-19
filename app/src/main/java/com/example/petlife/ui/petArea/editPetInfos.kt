package com.example.petlife.ui.petArea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.petlife.R
import com.example.petlife.databinding.ActivityEditPetInfosBinding
import com.example.petlife.domain.model.Pet

class editPetInfos : AppCompatActivity() {
    private val epib: ActivityEditPetInfosBinding by lazy {
        ActivityEditPetInfosBinding.inflate(layoutInflater)
    }

    private lateinit var petInfosForEdition: ActivityResultLauncher<Intent>

    private var selectedPet: Pet = Pet("", "", "", "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(epib.root)

        setSupportActionBar(epib.customToolbar.customToolbar)
        supportActionBar?.apply {
            title = "Edit pet info"
        }

        intent.getParcelableExtra<Pet>("pet_infos_for_edition")?.also { pet ->
            selectedPet = pet
            epib.petNameTextEt.setText(pet.name)
            epib.petSizeEt.setText(pet.size)
            epib.petColorEt.setText(pet.color)
            epib.petTypeEt.setText(pet.type)
            epib.petBirthDateEt.setText(pet.birthDate)
        }


        epib.saveEditBt.setOnClickListener {

            selectedPet.name = epib.petNameTextEt.text.toString()
            selectedPet.size = epib.petSizeEt.text.toString()
            selectedPet.color = epib.petColorEt.text.toString()
            selectedPet.type = epib.petTypeEt.text.toString()
            selectedPet.birthDate = epib.petBirthDateEt.text.toString()
            Intent().apply {

                putExtra("update_infos", selectedPet)
                setResult(RESULT_OK, this)
            }
            finish()
        }

        epib.cancelEditBt.setOnClickListener {
            Intent().apply {

                putExtra("update_infos", selectedPet)
                setResult(RESULT_OK, this)
            }
            finish()
        }

    }
}