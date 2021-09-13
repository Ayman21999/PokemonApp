package com.example.pokemonapp;

import com.example.pokemonapp.model.PokemonRespons;
import com.example.pokemonapp.network.PokemonApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {


    private PokemonApiService pokemonApiService;

    @Inject
    public Repository(PokemonApiService pokemonApiService) {
        this.pokemonApiService = pokemonApiService;
    }

    public Observable<PokemonRespons> getPokemons() {
        return pokemonApiService.getPokemons();
    }
}
