package com.example.pokemonapp.di;

import android.app.Application;

import androidx.room.Room;

import com.example.pokemonapp.db.PokemonDao;
import com.example.pokemonapp.db.PokemonDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {


    @Provides
    @Singleton
    public static PokemonDatabase providePokemonDB(Application application) {

        return Room.databaseBuilder(application, PokemonDatabase.class, "fav_table")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

    }
    @Singleton
    @Provides
    public static PokemonDao providePokemon(PokemonDatabase pokemonDatabase){
        return pokemonDatabase.pokemonDao();
    }

}
