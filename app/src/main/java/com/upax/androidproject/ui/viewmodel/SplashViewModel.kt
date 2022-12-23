package com.upax.androidproject.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upax.androidproject.data.Repository
import com.upax.androidproject.domain.models.Pokemon
import com.upax.androidproject.domain.usercases.PokemonUseCase
import com.upax.androidproject.util.Method
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase,
    private val repository: Repository) : ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>()

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> get() = _progress

    fun onCreate(context: Context){
        viewModelScope.launch {
            if(Method.isOnline(context)){
                _progress.postValue(0)
                val pokemon = pokemonUseCase.invoke()
                if(!pokemon.isNullOrEmpty()){
                    _pokemons.postValue(pokemon!!)
                }
                _progress.postValue(100)
            }else{
                _progress.postValue(0)
                _pokemons.postValue(repository.getAllPokemonFromDatabase())
                _progress.postValue(100)
            }
        }
    }
}