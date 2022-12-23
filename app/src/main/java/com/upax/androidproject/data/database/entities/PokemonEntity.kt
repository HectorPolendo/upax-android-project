package com.upax.androidproject.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.upax.androidproject.domain.models.Pokemon

@Entity(tableName = "Pokemon")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val name: String?,
    val front_default: String?
)

fun Pokemon.pokemonToEntity() = PokemonEntity(
    id,
    name,
    front_default
)

class GenresTypeConverter{
    @TypeConverter
    fun fromString(value: String?): List<String>{
        val listType = object: TypeToken<List<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList( list: List<String?>): String? {
        return Gson().toJson(list)
    }
}
