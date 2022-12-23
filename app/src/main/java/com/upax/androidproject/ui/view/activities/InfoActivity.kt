package com.upax.androidproject.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.upax.androidproject.databinding.ActivityInfoBinding
import com.upax.androidproject.ui.viewmodel.InfoViewModel
import com.upax.androidproject.util.Constants

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private val infoViewModel: InfoViewModel by viewModels()
    private var pokemonId: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInformation()

        Glide.with(this@InfoActivity)
            .load(Constants.PATH_IMGS+pokemonId!!+Constants.FORMAT_IMG)
            .into(binding.ivPokemon)

        //infoViewModel.onCreate(pokemonId!!)
        //subscribeObservers()
    }

    private fun getInformation() {
        pokemonId = intent.getIntExtra(Constants.POK_ID, 0)!!
    }

    private fun subscribeObservers() {
        infoViewModel.pokemon.observe(this,
            { t ->
                Glide.with(this@InfoActivity)
                    .load(Constants.PATH_IMGS+t!!.id+Constants.FORMAT_IMG)
                    .into(binding.ivPokemon)
            })
    }
}