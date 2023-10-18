package com.cantillana.kemekomo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.cantillana.kemekomo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val listOfPlatos= mutableListOf("Chuletón", "Tortilla de bacalao", "Croquetas",
        "Ensalada de pimientos", "Entrecote")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.azar()
        binding.ibRandom.setOnClickListener {
            this.azar()
        }
        binding.sbSelector.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                progresoLineal()
            }
        })
    }

    private fun progresoLineal(){
        val posicion=binding.sbSelector.progress
        binding.tvPlato.text= this.listOfPlatos[posicion]
        val tope=R.string.msg_tope+posicion
        Toast.makeText(this, tope, Toast.LENGTH_SHORT).show()
    }

    private fun azar(){
        val random=this.listOfPlatos.random()
        binding.tvPlato.text=random
        this.progresoLineal()
    }
}