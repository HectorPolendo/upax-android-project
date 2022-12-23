package com.upax.androidproject.domain.models

import com.upax.androidproject.data.database.entities.PokemonEntity
import com.upax.androidproject.data.network.pojos.PokemonResult

data class Pokemon(
    val id: Int?,
    val name: String?,
    val front_default: String?
)

fun PokemonResult.resultToModel() = Pokemon(
    id,
    name,
    front_default
)

fun PokemonEntity.entityToModel() = Pokemon(
    id,
    name,
    front_default
)

