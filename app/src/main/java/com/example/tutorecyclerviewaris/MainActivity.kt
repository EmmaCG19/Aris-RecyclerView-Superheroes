package com.example.tutorecyclerviewaris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutorecyclerviewaris.adapter.SuperHeroAdapter
import com.example.tutorecyclerviewaris.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //Para modificar la lista, es necesario que la misma sea mutable
    private lateinit var adapter: SuperHeroAdapter
    private var superHeroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.superheroList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        //Definimos un adapter para agregar o eliminar elementos
        adapter = SuperHeroAdapter(
            superheroList = superHeroMutableList,
            onClickListener = { superHero -> onItemSelected(superHero) },
            onClickDelete = { position -> onDeletedItem(position) }
        )

        val manager = LinearLayoutManager(this)
        binding.rvSuperheroes.layoutManager = manager
        binding.rvSuperheroes.adapter = adapter
    }

    private fun onItemSelected(hero: SuperHero) {
        Toast.makeText(
            this,
            "Nombre: ${hero.realName}, Identidad secreta: ${hero.superhero}, Publicador: ${hero.publisher}",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun onDeletedItem(itemPosition: Int) {
        superHeroMutableList.removeAt(itemPosition)
        adapter.notifyItemRemoved(itemPosition)
    }

}