package com.example.petlife.ui.userArea

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.R
import com.example.petlife.databinding.ActivityUserAreaBinding
import com.example.petlife.domain.model.Pet

class UserAreaActivity : AppCompatActivity() {
    private val amb: ActivityUserAreaBinding by lazy {
        ActivityUserAreaBinding.inflate(layoutInflater)
    }

    private lateinit var petActivityLaucher: ActivityResultLauncher<Intent>

    private var doguinho: Pet = Pet("Toto", "01/06/2000","medio" , "cao",
                        "preto", "10/10/2024", "12/10/2024",
                        "15/10/2024")

    private var gatinho: Pet = Pet("Bichano","01/06/2000","branco",  "gato",
        "branco", "10/10/2024", "12/10/2024",
        "15/10/2024")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        setSupportActionBar(amb.customToolbar.customToolbar)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
        }

        updateDogName()
        updateCatName()

        petActivityLaucher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getParcelableExtra<Pet>("back_to_user_area").let {
                    if (it?.type == doguinho.type) {
                        doguinho = it
                        updateDogName()
                    } else if (it?.type == gatinho.type) {
                        gatinho = it
                        updateCatName()
                    }
                }
            }
        }

        amb.seeDogsInfoBt.setOnClickListener {
            Intent("ACTION_TO_OPEN_PETS_INFO_SCREEN").apply {
                putExtra("pet_info", doguinho)
                petActivityLaucher.launch(this)
            }
        }

        amb.seeCattysInfoBt.setOnClickListener {
            println(gatinho);
            Intent("ACTION_TO_OPEN_PETS_INFO_SCREEN").apply {
                putExtra("pet_info", gatinho)
                petActivityLaucher.launch(this)
            }
        }
    }

    fun updateDogName() {
        amb.seeDogsInfoBt.text = doguinho.name
    }

    fun updateCatName() {
        amb.seeCattysInfoBt.text = gatinho.name
    }
}