package com.example.petlife.ui.userArea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.R
import com.example.petlife.databinding.ActivityMainBinding
import com.example.petlife.databinding.ActivityUserAreaBinding

class UserAreaActivity : AppCompatActivity() {
    private val amb: ActivityUserAreaBinding by lazy {
        ActivityUserAreaBinding.inflate(layoutInflater)
    }

    private lateinit var petActivityLaucher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        setSupportActionBar(amb.customToolbar.customToolbar)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            subtitle = this@UserAreaActivity.javaClass.canonicalName
        }

        petActivityLaucher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

        amb.seeDogsInfo.setOnClickListener {
            Intent("ACTION_TO_OPEN_PETS_INFO_SCREEN").apply {
                petActivityLaucher.launch(this)
            }
        }

    }
}