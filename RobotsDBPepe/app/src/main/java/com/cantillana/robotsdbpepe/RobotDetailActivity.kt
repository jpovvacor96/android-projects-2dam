package com.cantillana.robotsdbpepe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.cantillana.robotsdbpepe.databinding.ActivityRobotDetailBinding

class RobotDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRobotDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRobotDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle=intent.extras
        val nombre=bundle?.getString("nombre")
        val email=bundle?.getString("email")
        val info=bundle?.getString("info")
        val foto=bundle?.getString("foto")
        binding.tvNombre.text=nombre
        binding.tvEmail.text=email
        binding.tvInfo.text=info
        Glide.with(binding.ivFoto.context).load(foto).into(binding.ivFoto)
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}