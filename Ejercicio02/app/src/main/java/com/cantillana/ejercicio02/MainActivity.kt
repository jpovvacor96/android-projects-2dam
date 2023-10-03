package com.cantillana.ejercicio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cantillana.ejercicio02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**Variable necesaria para utilizar View Binding*/
    private lateinit var binding:ActivityMainBinding

    /**
     * Define el comportamiento de la aplicación al iniciarse
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIngresar.setOnClickListener{
            saludar()
        }
    }

    /**
     * Saluda al usuario si ha introducido un nombre o pide introducirle si no hay ninguno ingresado
     */
    private fun saludar(){
        if(!binding.etNombre.text.toString().isEmpty()){
            Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, "Escribe un texto", Toast.LENGTH_LONG).show()
        }
    }
}