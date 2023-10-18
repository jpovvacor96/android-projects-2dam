package com.cantillana.kemecomo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cantillana.kemecomo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val listOfPlatos= mutableListOf("Chuletón", "Tortilla de bacalao", "Croquetas",
        "Ensalada de pimientos", "Entrecote")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        azar()
        binding.btnSuerte.setOnClickListener {
            azar()
        }
        binding.btnNuevo.setOnClickListener {
            nuevoPlato()
        }
    }

    private fun azar(){
        val random=this.listOfPlatos.random()
        binding.tvPlato.text=random
    }

    private fun nuevoPlato(){
        val nuevoPlato=binding.etNuevo.text.toString()
        if(nuevoPlato.isNotEmpty()){
            this.listOfPlatos.add(nuevoPlato)
            binding.etNuevo.text.clear()
        }
        else{
            Toast.makeText(this, "No has añadido ningún plato nuevo", Toast.LENGTH_LONG).show()
        }
    }


}