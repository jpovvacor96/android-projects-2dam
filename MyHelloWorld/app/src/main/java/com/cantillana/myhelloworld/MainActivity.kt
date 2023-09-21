package com.cantillana.myhelloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Se establece la referencia con el botón de la vista
        val botonHola:Button=findViewById(R.id.bt_hello)
        //Pulsamos sobre el botón
        botonHola.setOnClickListener{
            sayHello()
        }
    }

    private fun sayHello(){
        val etTuNombre:EditText=findViewById(R.id.et_yourName)
        if(etTuNombre.text.toString().isEmpty()){
            Toast.makeText(this, R.string.msg_needName, Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, getString(R.string.msg_saludo, etTuNombre.text), Toast.LENGTH_SHORT).show()
        }
    }
}