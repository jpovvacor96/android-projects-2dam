package com.cantillana.botegracias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cantillana.botegracias.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.math.roundToInt

/**
 * Aplicación que permite el cálculo de propinas al camarero de acuerdo con la atención subjetiva
 * recibida percibida por el usuario. Tiene en cuenta el precio y una valoración personal que
 * corresponde con un porcentaje
 * @author José Palomino Ochoa
 */
class MainActivity : AppCompatActivity() {

    //##################
    //LISTA DE VARIABLES
    //##################

    /**Variable de vinculación de vistas*/
    private lateinit var binding: ActivityMainBinding

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
     * Determina el funcionamiento de la aplicación al iniciarse
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcular.setOnClickListener {
            calcular()
        }
    }

    /**
     * Calcula la propina de acuerdo con la valoración del camarero y el precio de la comida
     * considerando los errores de la no inclusión de ningún precio en el campo correspondiente
     * y la no selección de ninguna de las opciones de selección de valoración del camarero.
     * Además, se tiene en cuenta si se quieren decimales o no en el cálculo del total
     */
    private fun calcular() {
        //Se ha incluido un precio
        if (binding.etPrecio.text.toString().isNotEmpty()) {

            //Obtenemos el valor del precio
            Log.i(this.tagInfo, "Petición de calcular")
            val precio = binding.etPrecio.text.toString().toFloat()
            Log.i("info", "Precio introducido: $precio")
            var porcentaje = 0.0

            //Comprobamos la valoración del servicio
            if (binding.rbGenial.isChecked) {
                porcentaje = 0.2
                Log.i(this.tagInfo, "Servicio genial")
            } else if (binding.rbBien.isChecked) {
                porcentaje = 0.12
                Log.i(this.tagInfo, "Servicio bien")
            } else if (binding.rbCorrecto.isChecked) {
                porcentaje = 0.08
                Log.i(this.tagInfo, "Servicio correcto")
            } else {
                Toast.makeText(this, "Debes seleccionar una opción",
                    Toast.LENGTH_SHORT).show()
                Log.e(this.tagError, "No se ha seleccionado ninguna opción")
            }

            //Calculamos la propina y la mostramos
            val total = precio * porcentaje
            Log.i(this.tagInfo, "Resultado: $total")
            if (binding.swDecimales.isChecked) {
                binding.tvPropina.text = "Montante propina: ${total.roundToInt()}"
                Log.w(this.tagWarning, "El resultado se muestra aproximado")
            } else {
                val totalFormateado = DecimalFormat("0.00").format(total)
                binding.tvPropina.text = "Montante propina: $totalFormateado"
            }

        } else {
            //No se ha incluido ningún precio
            Toast.makeText(this, "Debes introducir el precio",
                Toast.LENGTH_SHORT).show()
            Log.e(this.tagError, "No se ha introducido ningún precio")
        }
    }
}