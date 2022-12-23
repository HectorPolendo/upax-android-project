package com.upax.androidproject.data.network

import com.upax.androidproject.data.network.pojos.PokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ServiceController @Inject constructor(private val api: ApiClient) {
    suspend fun getPokemons(): List<PokemonResult>{
        return withContext(Dispatchers.IO){
            val response = api.getAllPokemons()
            response.body()?.results ?: emptyList()
        }
    }
}