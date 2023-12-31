package com.cantillana.myrobots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cantillana.myrobots.adapter.RobotAdapter
import com.cantillana.myrobots.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rcRobots.layoutManager=LinearLayoutManager(this)
        binding.rcRobots.adapter=RobotAdapter( this, RobotProvider.robotList)
    }
}