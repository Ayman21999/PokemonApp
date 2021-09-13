package com.example.pokemonapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokemonapp.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PokemonDao {
    @Insert
    public void addToFav(Pokemon pokemon);
    @Query("DELETE FROM fav_table WHERE name =:name")
    public void deletePokemon(String name);
    @Query("SELECT * FROM fav_table")
    public LiveData<List<Pokemon>>getPokemons();
}
