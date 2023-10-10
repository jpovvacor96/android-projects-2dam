package com.cantillana.kemecomo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val listOfPlatos= mutableListOf<String>("Chuletón", "Gazpacho");
    //listOfPlatos.add("");
    //listOfPlatos.removeAt(index);
    //listOfPlatos.get(index);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}