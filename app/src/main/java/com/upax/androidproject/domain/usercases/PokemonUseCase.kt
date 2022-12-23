package com.upax.androidproject.domain.usercases

import com.upax.androidproject.data.Repository
import com.upax.androidproject.data.database.entities.pokemonToEntity
import com.upax.androidproject.domain.models.Pokemon
import javax.inject.Inject

class PokemonUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): List<Pokemon>{
        val result = repository.getPokemonsFromApi()
        return if(result.isNotEmpty()){
            repository.deletePokemon()
            repository.insertPokemons(result.map { it.pokemonToEntity() })
            result
        }else{
            repository.getAllPokemonFromDatabase()
        }
    }
}