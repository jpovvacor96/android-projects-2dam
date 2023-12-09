package com.cantillana.myfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cantillana.myfirebase.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val database=FirebaseDatabase.getInstance("https://myfirebase-3310a-default-rtdb." +
                "europe-west1.firebasedatabase.app/").reference
        val nombre=database.child("mascotas").child("gato")
            .child("nombre")
        val raza=database.child("mascotas").child("gato").child("raza")
        nombre.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.tvNombre.text="Nombre: ${snapshot.value}"
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
        raza.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.tvRaza.text="Raza: ${snapshot.value}"
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
        binding.btnAddUser.setOnClickListener {
            val users: MutableList<User> = ArrayList()
            users.add(User("María", "Carrasco García"))
            users.add(User("Rufino", "Rodríguez Sánchez"))
            users.add(User("Godofredo", "Neftarí García"))
            users.add(User("José", "Palomino Ochoa"))
            users.add(User("Marina", "Palomino Ochoa"))
            database.child("usuarios").setValue(users)
        }
    }
}