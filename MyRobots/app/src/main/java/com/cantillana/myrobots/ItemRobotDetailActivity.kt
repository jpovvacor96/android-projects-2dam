package com.cantillana.myrobots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.cantillana.myrobots.databinding.ItemRobotDetailBinding

class ItemRobotDetailActivity : AppCompatActivity() {

    private lateinit var binding:ItemRobotDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ItemRobotDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle=intent.extras
        val nombre=bundle?.getString("nombre")
        val apodo=bundle?.getString("apodo")
        val foto=bundle?.getString("foto")
        val info=bundle?.getString("info")
        binding.tvNombre.text=nombre
        binding.tvApodo.text=apodo
        Glide.with(binding.ivFoto.context).load(foto).into(binding.ivFoto)
        binding.tvInfo.text=info
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}