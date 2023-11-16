package com.cantillana.mysqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cantillana.mysqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAlta.setOnClickListener {
            alta()
        }
        binding.btnConsultaCod.setOnClickListener {
            consultaCod()
        }
        binding.btnConsultaDes.setOnClickListener {
            consultaDes()
        }
        binding.btnBajaCod.setOnClickListener {
            bajaCod()
        }
        binding.btnMod.setOnClickListener {
            modificacion()
        }
    }

    private fun alta(){
        if(!this.campoNulo()){
            val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd=admin.writableDatabase
            val registro=ContentValues()
            registro.put("codigo", binding.etCod.text.toString())
            registro.put("descripcion", binding.etDes.text.toString())
            registro.put("precio", binding.etPre.text.toString())
            bd.insert("articulos", null, registro)
            bd.close()
            binding.etCod.text.clear()
            binding.etDes.text.clear()
            binding.etPre.text.clear()
            Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Todos los campos son obligatorios",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun consultaCod(){
        if(binding.etCod.text.toString().isNotEmpty()){
            val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd=admin.writableDatabase
            val fila=bd.rawQuery("select descripcion, precio from articulos " +
                    "where codigo=${binding.etCod.text.toString()}", null)
            if(fila.moveToFirst()){
                binding.etDes.setText(fila.getString(0))
                binding.etPre.setText(fila.getString(1))
            }
            else{
                Toast.makeText(this, "No existe el artículo", Toast.LENGTH_SHORT).show()
            }
            bd.close()
        }
        else{
            Toast.makeText(this, "No se puede buscar por código sin código",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun consultaDes(){
        if(binding.etDes.text.toString().isNotEmpty()){
            val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd=admin.writableDatabase
            val fila=bd.rawQuery("select codigo,precio from articulos " +
                    "where descripcion='${binding.etDes.text.toString()}'", null)
            if(fila.moveToFirst()){
                binding.etCod.setText(fila.getString(0))
                binding.etPre.setText(fila.getString(1))
            }
            else{
                Toast.makeText(this, "No existe el artículo", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this, "No se puede buscar por descripción sin descripción",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun bajaCod(){
        val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd=admin.writableDatabase
        val cant=bd.delete("articulos", "codigo=${binding.etCod.text.toString()}",
            null)
        bd.close()
        binding.etCod.text.clear()
        binding.etDes.text.clear()
        binding.etPre.text.clear()
        if(cant==1){
            Toast.makeText(this, "Se ha borrado el artículo", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "No se ha borrado el artículo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun modificacion(){
        val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd=admin.writableDatabase
        val registro=ContentValues()
        registro.put("descripcion", binding.etDes.text.toString())
        registro.put("precio", binding.etPre.text.toString())
    }

    /**
    if(fila.moveToFirst()){
        do {
            binding.tvresult.append(fila.getString(0).toString()+" - ")
        }ehile(fila.moveToNext())
    }
    */

    private fun campoNulo(): Boolean {
        var nulo:Boolean=true
        if(binding.etCod.text.toString().isNotEmpty() && binding.etDes.text.toString().isNotEmpty()
            && binding.etPre.text.toString().isNotEmpty()){
            nulo=false
        }
        return nulo
    }

}