package com.upax.androidproject.data

import com.upax.androidproject.data.database.entities.PokemonDao
import com.upax.androidproject.data.database.entities.PokemonEntity
import com.upax.androidproject.data.network.ServiceController
import com.upax.androidproject.data.network.pojos.PokemonResult
import com.upax.androidproject.domain.models.Pokemon
import com.upax.androidproject.domain.models.entityToModel
import com.upax.androidproject.domain.models.resultToModel
import javax.inject.Inject

class Repository @Inject constructor(
    private val controller: ServiceController,
    private val dao: PokemonDao
) {

    suspend fun insertPokemons(list: List<PokemonEntity>){
        dao.insertPokemon(list)
    }

    suspend fun getPokemonsFromApi():List<Pokemon>{
        val response: List<PokemonResult> = controller.getPokemons()
        return response.map { it.resultToModel() }
    }

    suspend fun getAllPokemonFromDatabase(): List<Pokemon>{
        val response: List<PokemonEntity> = dao.readPokemons()
        return response.map { it.entityToModel() }
    }

    suspend fun getPokemonFromDatabaseById(id: Int): Pokemon{
        val response: PokemonEntity = dao.readPokemonById(id)
        return response.entityToModel()
    }

    suspend fun deletePokemon(){
        dao.deletePokemon()
    }
}