package com.cantillana.myherorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cantillana.myherorecyclerview.adapter.SuperHeroAdapter
import com.cantillana.myherorecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val superHeroFirst=SuperHero("Spiderman", "Marvel", "Peter Parker",
        "http:...")

    val superHeroList= listOf<SuperHero>(SuperHero("Spiderman", "Marvel"
        , "Peter Parker", "http"), SuperHero("Iron Man", "Marvel"
        , "Tony Stark", "http"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recyclerSuperHero.layoutManager=LinearLayoutManager(this)
        binding.recyclerSuperHero.adapter=SuperHeroAdapter(SuperHeroProvider.superheroList)
    }


}