package com.example.tutorecyclerviewaris.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tutorecyclerviewaris.SuperHero
import com.example.tutorecyclerviewaris.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemSuperheroBinding.bind(itemView)

    fun render(
        superHeroModel: SuperHero,
        onClickListener: (SuperHero) -> Unit,
        onClickDelete: (Int) -> Unit
    ) {
        binding.tvSuperHeroName.text = superHeroModel.superhero
        binding.tvPublisher.text = superHeroModel.publisher
        binding.tvRealName.text = superHeroModel.realName
        Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo).into(binding.ivSuperHero)

        itemView.setOnClickListener {
            onClickListener(superHeroModel)
        }

        binding.btnDelete.setOnClickListener {
            //Note: adapterPosition is deprecated, use bindingAdapterPosition
            Log.d("ViewHolderSuperHero", "Adapter position selected: $bindingAdapterPosition")
            onClickDelete(bindingAdapterPosition)
        }

    }

}