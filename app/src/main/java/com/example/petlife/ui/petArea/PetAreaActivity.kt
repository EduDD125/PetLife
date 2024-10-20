package com.example.petlife.ui.petArea

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.R
import com.example.petlife.databinding.ActivityPetAreaBinding
import com.example.petlife.domain.model.Pet

class PetAreaActivity : AppCompatActivity() {
    private val paa: ActivityPetAreaBinding by lazy {
        ActivityPetAreaBinding.inflate(layoutInflater)
    }

    private lateinit var editPetInfosActivity: ActivityResultLauncher<Intent>


    private var selectedPet: Pet = Pet("", "", "", "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(paa.root)

        setSupportActionBar(paa.customToolbar.customToolbar)
        supportActionBar?.apply {
        }

        editPetInfosActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getParcelableExtra<Pet>("updated_infos").let {
                    paa.petNameTextTv.text = it?.name
                    paa.petSizeTextTv.text = it?.size
                    paa.petColorTextTv.text = it?.color
                    paa.petTypeTextTv.text = it?.type
                    paa.petBirthDateTextTv.text = it?.birthDate
                    paa.petPetshopVisitTextTv.text = it?.lastPetshopVisit
                    paa.petVeterinarianVisitTextTv.text = it?.lastVetVisit
                    paa.petLastVaccinationTextTv.text = it?.lastVaccination
                }
            }
        }

        intent.getParcelableExtra<Pet>("pet_info")?.also { pet ->
            selectedPet = pet
            paa.petNameTextTv.text = pet.name
            paa.petSizeTextTv.text = pet.size
            paa.petColorTextTv.text = pet.color
            paa.petTypeTextTv.text = pet.type
            paa.petBirthDateTextTv.text = pet.birthDate
            paa.petPetshopVisitTextTv.text = pet.lastPetshopVisit
            paa.petVeterinarianVisitTextTv.text = pet.lastVetVisit
            paa.petLastVaccinationTextTv.text = pet.lastVaccination
        }



        paa.backBt.setOnClickListener {
            Intent().apply {

                putExtra("back_to_user_area", selectedPet)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pet, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.editPetInfos -> {
                Intent("ACTION_TO_OPEN_EDIT_PETS_INFOS_SCREEN").apply {
                    putExtra("pet_infos_for_edition", selectedPet)
                    editPetInfosActivity.launch(this)
                }
                true
            }
            R.id.editLastTimeInVet -> {
                Intent("ACTION_TO_OPEN_EDIT_PETS_LAST_VET_VISIT").apply {
                    putExtra("pet_infos_for_edition", selectedPet)
                    editPetInfosActivity.launch(this)
                }
                true
            }
            R.id.editLastTimeInPetshop -> {
                Intent("ACTION_TO_OPEN_EDIT_PETS_LAST_PETSHOP_VISIT").apply {
                    putExtra("pet_infos_for_edition", selectedPet)
                    editPetInfosActivity.launch(this)
                }
                true
            }
            R.id.editLastVaccination -> {
                Intent("ACTION_TO_OPEN_EDIT_PETS_LAST_VACCINATION").apply {
                    putExtra("pet_infos_for_edition", selectedPet)
                    editPetInfosActivity.launch(this)
                }
                true
            }
            else -> { false }
        }
    }
}