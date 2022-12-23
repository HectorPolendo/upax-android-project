package com.upax.androidproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upax.androidproject.data.Repository
import com.upax.androidproject.domain.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _popular = MutableLiveData<List<Pokemon>>()
    val popular: LiveData<List<Pokemon>> get() = _popular

    fun onCreate(){
        viewModelScope.launch {
            _popular.postValue(repository.getAllPokemonFromDatabase())
        }
    }
}