package com.cantillana.myimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton:Button=findViewById(R.id.btn)
        boton.setOnClickListener {
            cambiarImagen()
        }
    }

    private fun cambiarImagen(){
        val ivEscudo:ImageView=findViewById(R.id.iv_escudo)
        val ivCat:ImageView=findViewById(R.id.iv_cat)
        if(ivEscudo.isVisible){
            ivEscudo.isVisible=false;
        }
        else{
            ivEscudo.isVisible=true;
        }
    }
}