package com.upax.androidproject.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upax.androidproject.databinding.ListItemsBinding
import com.upax.androidproject.domain.models.Pokemon
import com.upax.androidproject.util.Constants

class PokemonAdapter(): RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    private var pokemonList = ArrayList<Pokemon>()
    lateinit var onItemClick: ((Pokemon)->Unit)

    fun setPokemons(pokemonList: ArrayList<Pokemon>){
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        Glide.with(holder.itemView)
            .load(Constants.PATH_IMGS+pokemonList[position].id+Constants.FORMAT_IMG)
            .into(holder.binding.ivPokemon)

        holder.binding.tvPokemon.text = pokemonList[position].name

        holder.itemView.setOnClickListener{
            onItemClick.invoke(pokemonList[position])
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    class ViewHolder(val binding: ListItemsBinding): RecyclerView.ViewHolder(binding.root)
}