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
    private lateinit var editLastPetshopDateActivity: ActivityResultLauncher<Intent>
    private lateinit var editLastVetVisitDateActivity: ActivityResultLauncher<Intent>
    private lateinit var editLastVaccinationDateActivity: ActivityResultLauncher<Intent>


    private lateinit var selectedPet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(paa.root)

        setSupportActionBar(paa.customToolbar.customToolbar)

        editPetInfosActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getParcelableExtra<Pet>("updated_infos").let {
                    updatePetDetails()
                }
            }
        }

        editLastPetshopDateActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getStringExtra("back_from_edit_petshop_visit_date")?.let {
                    selectedPet.lastPetshopVisit = it
                    paa.petPetshopVisitTextTv.text = it
                }
            }
        }

        editLastVetVisitDateActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getStringExtra("back_from_edit_vet_visit_date")?.let {
                    selectedPet.lastVetVisit = it
                    paa.petVeterinarianVisitTextTv.text = it
                }
            }
        }

        editLastVaccinationDateActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getStringExtra("back_from_edit_vaccination_date")?.let {
                    selectedPet.lastVaccination = it
                    paa.petLastVaccinationTextTv.text = it
                }
            }
        }




        intent.getParcelableExtra<Pet>("pet_info")?.also { pet ->
            selectedPet = pet
            updatePetDetails()
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
                    putExtra("last_vet_visit_date_edit", selectedPet.lastVetVisit)
                    editLastVetVisitDateActivity.launch(this)
                }
                true
            }
            R.id.editLastTimeInPetshop -> {
                Intent("ACTION_TO_OPEN_EDIT_PETS_LAST_PETSHOP_VISIT").apply {
                    putExtra("last_petshop_visit_date_edit", selectedPet.lastPetshopVisit)
                    editLastPetshopDateActivity.launch(this)
                }
                true
            }
            R.id.editLastVaccination -> {
                Intent("ACTION_TO_OPEN_EDIT_PETS_LAST_VACCINATION").apply {
                    putExtra("last_vaccination_date_edit", selectedPet.lastVaccination)
                    editLastVaccinationDateActivity.launch(this)
                }
                true
            }
            else -> { false }
        }
    }

    private fun updatePetDetails() {
        paa.petNameTextTv.text = selectedPet.name
        paa.petSizeTextTv.text = selectedPet.size
        paa.petColorTextTv.text = selectedPet.color
        paa.petTypeTextTv.text = selectedPet.type
        paa.petBirthDateTextTv.text = selectedPet.birthDate
        paa.petPetshopVisitTextTv.text = selectedPet.lastPetshopVisit
        paa.petVeterinarianVisitTextTv.text = selectedPet.lastVetVisit
        paa.petLastVaccinationTextTv.text = selectedPet.lastVaccination
    }
}