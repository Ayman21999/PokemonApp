package com.example.pokemonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.pokemonapp.adapter.PokemonAdapter;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.viewmodels.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint

public class FavActivity extends AppCompatActivity {
    private PokemonViewModel pokemonViewModel;
    private RecyclerView pokemonList;
    PokemonAdapter adapter;
    Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        pokemonList = findViewById(R.id.pokemon_list);
        goHome = findViewById(R.id.fav);
        adapter=  new PokemonAdapter(this);
        pokemonList.setLayoutManager(new LinearLayoutManager(this));
        pokemonList.setAdapter(adapter);
        pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
        pokemonViewModel.getFavPokemons();

        pokemonViewModel.getListLiveData().observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(List<Pokemon> pokemons) {

                adapter.setList((ArrayList<Pokemon>) pokemons);
            }
        });

        setUpSwipe();

    }

    public void setUpSwipe() {
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedItemPosistion = viewHolder.getAdapterPosition();
                Pokemon swipedPokmon = adapter.getPokemonPosistion(swipedItemPosistion);
                pokemonViewModel.deletePolemon(swipedPokmon.getName());
                adapter.notifyDataSetChanged();

                Toast.makeText(FavActivity.this, "Delete item form Database", Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(pokemonList);
    }
}