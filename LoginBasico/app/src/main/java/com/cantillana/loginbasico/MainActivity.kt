package com.cantillana.loginbasico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cantillana.loginbasico.databinding.ActivityMainBinding

/**
 * Determina el funcionamiento de la vista principal de la aplicación, en la que solicitamos el
 * ingreso de un nombre de usuario y una contraseña y comprobemos que ambos campos sean los
 * correctos comparándolos con unos valores predefinidos
 * @author José Palomino Ochoa
 */
class MainActivity : AppCompatActivity() {

    //##################
    //LISTA DE ATRIBUTOS
    //##################

    /**Variable de vinculación de vistas viewBinding*/
    private lateinit var binding: ActivityMainBinding

    /**Nombre de usuario correcto*/
    private val correctUser: String = "pepe"

    /**Contraseña correcta*/
    private val correctPassword: String = "pepe1996"

    /**Etiqueta de los mensajes de Log de nivel INFO*/
    private val tagInfo: String = "[INFO]"

    /**Etiqueta de los mensajes de Log de nivel WARNING*/
    private val tagWarning: String = "[WARN]"

    /**Etiqueta de los mensajes de Log de nivel ERROR*/
    private val tagError: String = "[ERROR]"

    //###################
    //MÉTODOS FUNCIONALES
    //###################

    /**
     * Determina el comportamiento de la actividad al inciarse
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(this.tagInfo, "Inicio de la actividad principal")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            Log.i(this.tagInfo, "Pulsado el botón de login")
            login()
        }
    }

    /**
     * Permite al usuario ingresar el nombre de usuario y contraseña y evaluar si es correcta.
     * Consideramos los casos en los que no se introduce algún valor o alguno de ellos es
     * incorrecto. Si ambos datos son correctos, el método inicia la actividad de login correcto
     */
    private fun login() {
        if (binding.etUser.text.isNotEmpty()) {
            if (binding.etPassword.text.isNotEmpty()) {
                if (binding.etUser.text.toString() == this.correctUser) {
                    if (binding.etPassword.text.toString() == this.correctPassword) {
                        Log.i(this.tagInfo, "Datos de acceso correctos")
                        val intento1 = Intent(this, LoginCorrect::class.java)
                        intento1.putExtra("user", binding.etUser.text.toString())
                        startActivity(intento1)
                    } else {
                        Toast.makeText(
                            this, "Contraseña incorrecta",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.w(this.tagWarning, "La contraseña es incorrecta")
                    }
                } else {
                    Toast.makeText(
                        this, "No existe ese usuario",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.w(this.tagWarning, "No existe el usuario introducido")
                }
            } else {
                Toast.makeText(
                    this, "Debes incluir una contraseña",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e(this.tagError, "No se ha incluido una contraseña")
            }
        } else {
            Toast.makeText(
                this, "Debes incluir un nombre de usuario",
                Toast.LENGTH_SHORT
            ).show()
            Log.e(this.tagError, "No se ha incluido un nombre de usuario")
        }
    }
}