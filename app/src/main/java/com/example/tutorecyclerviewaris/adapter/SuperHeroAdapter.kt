package com.example.tutorecyclerviewaris.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorecyclerviewaris.R
import com.example.tutorecyclerviewaris.SuperHero

class SuperHeroAdapter(
    private val superheroList: List<SuperHero>,
    private val onClickListener: (SuperHero) -> Unit,
    private val onClickDelete: (Int) -> Unit
) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperHeroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superheroList[position]
        holder.render(item, onClickListener, onClickDelete)
    }

    override fun getItemCount() = superheroList.size
}