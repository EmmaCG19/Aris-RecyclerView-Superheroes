package com.example.tutorecyclerviewaris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutorecyclerviewaris.adapter.SuperHeroAdapter
import com.example.tutorecyclerviewaris.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        //Set Layout Manager
        val manager = LinearLayoutManager(this)
        binding.rvSuperheroes.layoutManager = manager


        //How to pass a lambda function to the adapter to return a superhero object on the activity
        binding.rvSuperheroes.adapter =
            SuperHeroAdapter(SuperHeroProvider.superheroList) { superhero ->
                onItemSelected(superhero)
            }
    }

    private fun onItemSelected(hero: SuperHero) {
        Toast.makeText(
            this,
            "Nombre: ${hero.realName}, Identidad secreta: ${hero.superhero}, Publicador: ${hero.publisher}",
            Toast.LENGTH_LONG
        ).show()
    }
}