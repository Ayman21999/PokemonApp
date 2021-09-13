package com.example.pokemonapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokemonapp.R;
import com.example.pokemonapp.model.Pokemon;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.Pokemonholder>{

    ArrayList<Pokemon> Pokmons = new ArrayList<>();
    Context context;

    public PokemonAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public Pokemonholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.poke_item, parent, false);
        return new Pokemonholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Pokemonholder holder, int position) {
        Pokemon pokemon = Pokmons.get(position);

        holder.poke_name.setText(pokemon.getName());
        Glide.with(context).load(pokemon.getUrl()).into(holder.poke_image);
        
        holder.poke_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "The Url : " + pokemon.getUrl(), Toast.LENGTH_SHORT).show();
                Log.d("ttt","The Url : " + pokemon.getUrl());
            }
        });
 }

    @Override
    public int getItemCount() {
        return Pokmons.size();
    }

    public void setList(ArrayList<Pokemon> Pokmons) {
        this.Pokmons = Pokmons;
        notifyDataSetChanged();
    }

    public Pokemon getPokemonPosistion(int pos){
        return Pokmons.get(pos);
    }
    public class Pokemonholder extends RecyclerView.ViewHolder {
        private TextView poke_name;
        ImageView poke_image;

        public Pokemonholder(@NonNull View itemView) {
            super(itemView);
            poke_name = itemView.findViewById(R.id.pokemon_name);
            poke_image = itemView.findViewById(R.id.pokemonimage);
        }
    }
}
