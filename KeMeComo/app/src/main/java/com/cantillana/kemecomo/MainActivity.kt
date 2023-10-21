package com.cantillana.kemecomo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cantillana.kemecomo.databinding.ActivityMainBinding

/**
 * Primera versión de la aplicación KeMeKomo. Permite la inclusión de nuevos elementos en la lista
 * de platos diponibles (aunque no disponemos de persistencia aún), y al pulsar un botón se muestra
 * uno de ellos de forma aleatoria, ayudando al usuario a decidirse por uno de los platos
 * @author José Palomino Ochoa
 */
class MainActivity : AppCompatActivity() {

    //##################
    //LISTA DE ATRIBUTOS
    //##################

    /**Variable de vinculación de vistas viewBinding*/
    private lateinit var binding: ActivityMainBinding

    /**Lista de platos disponibles*/
    private val listOfPlatos= mutableListOf("Chuletón", "Tortilla de bacalao", "Croquetas",
        "Ensalada de pimientos", "Entrecote")

    /**Etiqueta de los mensajes de Log de nivel INFO*/
    private val tagInfo:String="[INFO]"

    /**Etiqueta de los mensajes de Log de nivel ERROR*/
    private val tagError:String="[ERROR]"

    //###################
    //MÉTODOS FUNCIONALES
    //###################

    /**
     * Determina el funcionamiento de la aplicación al iniciarse
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(this.tagInfo, "Inicio de la aplicación")
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        azar()
        Log.i(this.tagInfo, "Muestra inicial de plato aleatorio")
        binding.btnSuerte.setOnClickListener {
            Log.i(this.tagInfo, "Se ha pulsado el botón de échalo a suertes")
            azar()
        }
        binding.btnNuevo.setOnClickListener {
            Log.i(this.tagInfo, "Se ha pulsado el botón de inclusión de nuevo plato")
            nuevoPlato()
        }
    }

    /**
     * Muestra un plato al azar de la lista de platos disponibles
     */
    private fun azar(){
        Log.i(this.tagInfo, "Echamos a suertes el plato")
        val random=this.listOfPlatos.random()
        binding.tvPlato.text=random
    }

    /**
     * Incluye un nuevo plato en la lista de platos disponibles, teniendo en cuenta el error de no
     * haber introducido ninguno en el campo de texto
     */
    private fun nuevoPlato(){
        val nuevoPlato=binding.etNuevo.text.toString()
        if(nuevoPlato.isNotEmpty()){
            this.listOfPlatos.add(nuevoPlato)
            binding.etNuevo.text.clear()
            Log.i(this.tagInfo, "Nuevo plato ($nuevoPlato) incluido correctamente")
        }
        else{
            Toast.makeText(this, "No has añadido ningún plato nuevo",
                Toast.LENGTH_LONG).show()
            Log.e(this.tagError, "No se puede incluir un plato sin nombre")
        }
    }


}