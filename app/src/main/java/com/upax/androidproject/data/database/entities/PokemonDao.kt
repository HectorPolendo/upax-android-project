package com.upax.androidproject.data.database.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {
    /**
     MOST POPULAR
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemons: List<PokemonEntity>)

    @Query("SELECT * FROM Pokemon")
    suspend fun readPokemons(): List<PokemonEntity>

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    suspend fun readPokemonById(id: Int): PokemonEntity

    @Query("DELETE FROM Pokemon")
    suspend fun deletePokemon()
}