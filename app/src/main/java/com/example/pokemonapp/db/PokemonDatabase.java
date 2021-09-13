package com.example.pokemonapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = PokemonDao.class , version = 1 ,exportSchema = false)
public abstract class  PokemonDatabase extends RoomDatabase {
}
