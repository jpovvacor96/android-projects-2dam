package com.cantillana.robotsdbpepe

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.cantillana.robotsdbpepe.databinding.ActivityMainBinding

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
        binding.btnBajaCod.setOnClickListener {
            bajaCod()
        }
        binding.btnMod.setOnClickListener {
            modificar()
        }
        binding.etNombre.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                binding.etFoto.setText("https://robohash.org/${p0}")
                binding.etInfo.setText("At vero eos et accusamus et iusto odio dignissimos " +
                        "ducimus qui blanditiis praesentium voluptatum deleniti atque " +
                        "corrupti quos dolores et quas molestias excepturi sint occaecati.")
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
        binding.btnLimpiar.setOnClickListener {
            limpiarCampos()
        }
        binding.btnMostrarRecycler.setOnClickListener {
            mostrarRecycler()
        }
    }

    private fun alta(){
        if(binding.etCod.text.toString().isNotEmpty() &&
            binding.etNombre.text.toString().isNotEmpty()){
            if(!existe(binding.etCod.text.toString())){
                val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val bd=admin.writableDatabase
                val registro=ContentValues()
                registro.put("codigo", binding.etCod.text.toString())
                registro.put("nombre", binding.etNombre.text.toString())
                registro.put("email", binding.etEmail.text.toString())
                registro.put("info", binding.etInfo.text.toString())
                registro.put("foto", binding.etFoto.text.toString())
                bd.insert("robots", null, registro)
                bd.close()
                limpiarCampos()
                Toast.makeText(this, "Se cargaron los datos del robot",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Ya existe un registro con ese código",
                    Toast.LENGTH_SHORT).show()
                limpiarCampos()
            }
        }
        else{
            Toast.makeText(this, "Falta algún dato obligatorio",
                Toast.LENGTH_SHORT).show()
            limpiarCampos()
        }
    }

    private fun consultaCod(){
        if(binding.etCod.text.toString().isNotEmpty()){
            if(existe(binding.etCod.text.toString())){
                val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val bd=admin.writableDatabase
                val fila=bd.rawQuery("select nombre, email, info, foto from robots " +
                        "where codigo=${binding.etCod.text}", null)
                if(fila.moveToFirst()){
                    binding.etNombre.setText(fila.getString(0))
                    binding.etEmail.setText(fila.getString(1))
                    binding.etInfo.setText(fila.getString(2))
                    binding.etFoto.setText(fila.getString(3))
                }
                else{
                    Toast.makeText(this, "No existe el robot", Toast.LENGTH_SHORT).show()
                }
                bd.close()
                fila.close()
            }
            else{
                Toast.makeText(this, "No existe ningún robot con ese codigo",
                    Toast.LENGTH_SHORT).show()
                limpiarCampos()
            }
        }
        else{
            Toast.makeText(this, "No se puede buscar por código sin código",
                Toast.LENGTH_SHORT).show()
            limpiarCampos()
        }
    }

    private fun bajaCod(){
        val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd=admin.writableDatabase
        val cant=bd.delete("robots", "codigo=${binding.etCod.text}",
            null)
        bd.close()
        limpiarCampos()
        if(cant==1){
            Toast.makeText(this, "Se ha borrado el robot", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "No se ha borrado el robot", Toast.LENGTH_SHORT).show()
        }
    }

    private fun modificar(){
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", binding.etNombre.text.toString())
        registro.put("email", binding.etEmail.text.toString())
        registro.put("info", binding.etInfo.text.toString())
        registro.put("foto", binding.etFoto.text.toString())
        val cant = bd.update("robots", registro,
            "codigo=${binding.etCod.text}", null)
        bd.close()
        limpiarCampos()
        if (cant == 1)
            Toast.makeText(this, "Modificación de los datos correcta",
                Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "No se han modificado los datos",
                Toast.LENGTH_SHORT).show()
    }

    private fun existe(cod: String): Boolean{
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd=admin.writableDatabase
        val fila=bd.rawQuery("SELECT * FROM robots WHERE codigo=$cod", null)
        val existeRegistro=fila.moveToFirst()
        fila.close()
        bd.close()
        return existeRegistro
    }


    private fun mostrarRecycler(){
        val intento1=Intent(this, ListActivity::class.java)
        this.startActivity(intento1)
    }

    private fun limpiarCampos(){
        binding.etCod.text.clear()
        binding.etNombre.text.clear()
        binding.etEmail.text.clear()
        binding.etInfo.text.clear()
        binding.etFoto.text.clear()
    }
}