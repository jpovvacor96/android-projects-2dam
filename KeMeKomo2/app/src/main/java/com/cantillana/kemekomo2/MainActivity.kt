package com.cantillana.kemekomo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import com.cantillana.kemekomo2.databinding.ActivityMainBinding
import kotlin.random.Random

/**
 * Representa la capa de negocio de la aplicación de KeMeKomo2, que incluye, al contrario que en
 * la versión anterior, un "seekBar" para seleccionar el plato que deseamos y un imageButton que
 * permite elegir un plato aleatorio
 * @author José Palomino Ochoa
 */
class MainActivity : AppCompatActivity() {

    //##################
    //LISTA DE ATRIBUTOS
    //##################

    /**Variable de vinculación de vistas viewBinding*/
    private lateinit var binding: ActivityMainBinding

    /**Lista de platos disponibles a elegir*/
    private val listOfPlatos= mutableListOf("Chuletón", "Tortilla de bacalao", "Croquetas",
        "Ensalada de pimientos", "Entrecote")

    /**Etiqueta de los mensajes de Log de nivel INFO*/
    private val tagInfo:String="[INFO]"

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
        this.azar()

        //Qué acciones realizar al pulsar en el botón de aleatorio
        binding.ibRandom.setOnClickListener {
            Log.i(this.tagInfo, "Se ha pulsado el botón de plato aleatorio")
            this.azar()
        }

        //Qué acciones realizar al modificar la posición del seekBar
        binding.sbSelector.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                progresoLineal()
            }
        })
    }

    /**
     * Determina el comportamiento de la aplicación al modificarse la posición de la barra
     * de selección
     */
    private fun progresoLineal(){
        Log.i(this.tagInfo, "Cambio en la barra de selección")
        val posicion=binding.sbSelector.progress
        binding.tvPlato.text= this.listOfPlatos[posicion]
        Toast.makeText(this, "El tope es: ${posicion+1}", Toast.LENGTH_SHORT).show()
        Log.i(this.tagInfo, "El tope es: $posicion")
    }

    /**
     * Muestra un plato aleatorio de la lista de platos disponibles
     */
    private fun azar(){
        val random= Random.nextInt(0, 5)
        Log.i(this.tagInfo, "Número aleatorio obtenido: $random")
        binding.tvPlato.text=this.listOfPlatos.get(random)
        binding.sbSelector.progress=random
        Log.i(this.tagInfo, "Presentado un nuevo plato aleatorio")
    }
}