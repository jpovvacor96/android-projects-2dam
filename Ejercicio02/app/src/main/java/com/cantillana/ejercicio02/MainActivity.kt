package com.cantillana.ejercicio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cantillana.ejercicio02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //##################
    //LISTA DE ATRIBUTOS
    //##################

    /**Variable necesaria para utilizar View Binding*/
    private lateinit var binding:ActivityMainBinding

    //###################
    //MÉTODOS FUNCIONALES
    //###################

    /**
     * Define el comportamiento de la aplicación al iniciarse
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIngresar.setOnClickListener {
            calcular()
        }
    }

    private fun calcular(){
        val numero1=binding.etPrimero.text.toString().toInt()
        val numero2=binding.etSegundo.text.toString().toInt()
        var resultado=0
        if(binding.cb1.isChecked){
            resultado=numero1+numero2
        }
        binding.tvResultado.text="Resultado: ${resultado}"
    }
}