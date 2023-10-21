package com.cantillana.loginbasico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cantillana.loginbasico.databinding.ActivityLoginCorrectBinding

/**
 * Determina el funcionamiento de la actividad LoginCorrect, que se inicia cuando se introducen
 * en la actividad principal un nombre de usuario y contraseña correctos. En esta actividad se
 * saluda al usuario por su nombre y dispone de un botón para volver a la actividad principal
 * @author José Palomino Ochoa
 */
class LoginCorrect : AppCompatActivity() {

    //##################
    //LISTA DE ATRIBUTOS
    //##################

    /**Variable de vinculación de vistas viewBinding*/
    private lateinit var binding:ActivityLoginCorrectBinding

    /**Etiqueta de los mensajes de Log de nivel INFO*/
    private val tagInfo:String="[INFO]"

    //###################
    //MÉTODOS FUNCIONALES
    //###################

    /**
     * Determina el funcionamiento de la actividad al iniciarse
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(this.tagInfo, "Inicio de la vista de login correcto")
        super.onCreate(savedInstanceState)
        binding=ActivityLoginCorrectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle=intent.extras
        val user=bundle?.getString("user")
        binding.tvSaludo.text="Bienvenido, $user"
        binding.btnLogin.setOnClickListener {
            Log.i(this.tagInfo, "Se ha pulsado el botón de regreso")
            finish()
        }
    }
}