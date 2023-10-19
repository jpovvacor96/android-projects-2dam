package com.cantillana.botegracias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.cantillana.botegracias.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var tagError:String="[ERROR]"

    private var tagInfo:String="[INFO]"

    private var tagWarning:String="[WARN]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular(){
        if(binding.etPrecio.text.toString().isNotEmpty()){
            Log.i(this.tagInfo, "Petición de calcular")
            val precio=binding.etPrecio.text.toString().toFloat()
            Log.i("info", "Precio introducido: ${precio}")
            var porcentaje=0.0
            if(binding.rbGenial.isChecked){
                porcentaje=0.2
                Log.i(this.tagInfo, "Servicio genial")
            }
            else if(binding.rbBien.isChecked){
                porcentaje=0.12
                Log.i(this.tagInfo, "Servicio bien")
            }
            else if(binding.rbCorrecto.isChecked){
                porcentaje=0.08
                Log.i(this.tagInfo, "Servicio correcto")
            }
            else{
                Toast.makeText(this, "Debes seleccionar una opción", Toast.LENGTH_SHORT).show()
                Log.e(this.tagError, "No se ha seleccionado ninguna opción")
            }
            val total=precio*porcentaje
            Log.i(this.tagInfo, "Resultado: ${total}")
            if(binding.swDecimales.isChecked){
                binding.tvPropina.text="Montante propina: ${total.roundToInt()}"
                Log.w(this.tagWarning, "El resultado se muestra aproximado")
            }
            else{
                val totalFormateado=DecimalFormat("0.00").format(total)
                binding.tvPropina.text="Montante propina: ${totalFormateado}"
            }
        }
        else{
            Toast.makeText(this, "Debes introducir el precio", Toast.LENGTH_SHORT).show()
            Log.e(this.tagError, "No se ha introducido ningún precio")
        }
    }
}