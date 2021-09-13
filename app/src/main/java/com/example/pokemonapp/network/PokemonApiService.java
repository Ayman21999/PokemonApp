package com.example.pokemonapp.network;


import com.example.pokemonapp.model.PokemonRespons;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonApiService {
    // Read data from API by retrofit
    @GET("pokemon")
    Observable<PokemonRespons> getPokemons();

}
