package com.upax.androidproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.upax.androidproject.data.database.entities.GenresTypeConverter
import com.upax.androidproject.data.database.entities.PokemonDao
import com.upax.androidproject.data.database.entities.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1, exportSchema = false)
@TypeConverters(GenresTypeConverter::class)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}