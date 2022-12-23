package com.upax.androidproject.di

import android.content.Context
import androidx.room.Room
import com.upax.androidproject.data.database.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DATABASE_NAME = "pokemon_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PokemonDatabase::class.java, QUOTE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: PokemonDatabase) = db.pokemonDao()
}