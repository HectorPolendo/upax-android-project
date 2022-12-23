package com.upax.androidproject.data.network.pojos

data class PokemonResponse(
    val page: Int,
    val results: List<PokemonResult>,
    val total_pages: Int,
    val total_results: Int
)