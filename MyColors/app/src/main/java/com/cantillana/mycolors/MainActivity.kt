package com.cantillana.mycolors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btn_seleccion)
        btn.setOnClickListener{
            sayHello()
        }
        //Referenciamos el switch
        val swPrueba: Switch=findViewById(R.id.sw_prueba)
        //Chequeamos el switch
        swPrueba.setOnCheckedChangeListener{ _, isChecked->btn.isEnabled=isChecked}

    }

    private fun sayHello(){
        val etNombre: EditText=findViewById(R.id.et_nombre)
        val r1: RadioButton=findViewById(R.id.rb_opcion1)
        val r2: RadioButton=findViewById(R.id.rb_opcion2)
        if(etNombre.text.isEmpty()){
            Toast.makeText(this, R.string.msgNeedName, Toast.LENGTH_LONG).show()
        }
        else if(r1.isChecked){
            Toast.makeText(this, getString(R.string.msgSaludo, etNombre.text),
                Toast.LENGTH_LONG).show()
        }
        else if(r2.isChecked){
            Toast.makeText(this, getString(R.string.msgDespedida, etNombre.text),
                Toast.LENGTH_LONG).show()
        }
    }


}