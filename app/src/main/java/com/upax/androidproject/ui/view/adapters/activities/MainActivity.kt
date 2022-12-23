package com.upax.androidproject.ui.view.adapters.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upax.androidproject.R
import com.upax.androidproject.databinding.ActivityMainBinding
import com.upax.androidproject.domain.models.Pokemon
import com.upax.androidproject.ui.view.adapters.PokemonAdapter
import com.upax.androidproject.ui.view.fragments.HomeFragment
import com.upax.androidproject.ui.viewmodel.PokemonViewModel
import com.upax.androidproject.ui.viewmodel.SplashViewModel
import com.upax.androidproject.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pokemonViewModel: PokemonViewModel by viewModels()
    private lateinit var mostPopularAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonViewModel.onCreate()

        initAdapters()

        binding.rvPokemons.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mostPopularAdapter
        }

        itemsClicks()

        subscribeObservers()
    }

    fun initAdapters(){
        mostPopularAdapter = PokemonAdapter()
    }

    fun itemsClicks(){
        mostPopularAdapter.onItemClick = {
            startActivity(Intent(this, InfoActivity::class.java))
        }
    }

    fun subscribeObservers(){
        pokemonViewModel.popular.observe(this, {
            mostPopularAdapter.setPokemons(it as ArrayList<Pokemon>)
        })
    }
}