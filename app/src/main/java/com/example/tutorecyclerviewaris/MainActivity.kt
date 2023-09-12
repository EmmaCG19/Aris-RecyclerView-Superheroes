package com.example.tutorecyclerviewaris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutorecyclerviewaris.adapter.SuperHeroAdapter
import com.example.tutorecyclerviewaris.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val llmanager = LinearLayoutManager(this)

    //Para modificar la lista, es necesario que la misma sea mutable
    private lateinit var adapter: SuperHeroAdapter
    private var superHeroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.superheroList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initListeners()
    }

    private fun initListeners() {
        binding.btnAddSuperHero.setOnClickListener {
            createSuperHero()
        }
    }

    private fun createSuperHero() {
        //Creating superhero
        val newSuperHero = SuperHero(
            "Capitanazo",
            "Casa de los dibujos",
            "?????",
            "https://pbs.twimg.com/profile_images/1324203760332296192/_iITFdoT_400x400.jpg"
        )

        //Inserting superhero
        val insertedPos = 3
        superHeroMutableList.add(insertedPos, newSuperHero)
        adapter.notifyItemInserted(insertedPos)

        //Scrolling to position after item is inserted
        llmanager.scrollToPositionWithOffset(insertedPos, 20)

    }

    private fun initRecyclerView() {
        //Definimos un adapter para agregar o eliminar elementos
        adapter = SuperHeroAdapter(
            superheroList = superHeroMutableList,
            onClickListener = { superHero -> onItemSelected(superHero) },
            onClickDelete = { position -> onDeletedItem(position) }
        )

        binding.rvSuperheroes.layoutManager = llmanager
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