package com.example.pokemonapp.repository;

import androidx.lifecycle.LiveData;

import com.example.pokemonapp.db.PokemonDao;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.model.PokemonRespons;
import com.example.pokemonapp.network.PokemonApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {


    private PokemonApiService pokemonApiService;
     PokemonDao pokemonDao;


    @Inject
    public Repository(PokemonApiService pokemonApiService , PokemonDao pokemonDao) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonDao  = pokemonDao;
    }

    public Observable<PokemonRespons> getPokemons() {
        return pokemonApiService.getPokemons();
    }

    public void insertPokemon(Pokemon pokemon){pokemonDao.addToFav(pokemon);}
    public void deletePokemon(String pokemonName){pokemonDao.deletePokemon(pokemonName);}
    public LiveData<List<Pokemon>>getFavPokemons(){
        return pokemonDao.getPokemons();
    }

}
