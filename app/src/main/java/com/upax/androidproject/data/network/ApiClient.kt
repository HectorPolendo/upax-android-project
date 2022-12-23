package com.upax.androidproject.data.network

import com.upax.androidproject.data.network.pojos.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("pokemon/")
    suspend fun getAllPokemons(): Response<PokemonResponse>
}