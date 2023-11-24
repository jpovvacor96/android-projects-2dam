package com.cantillana.robotsdbpepe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.cantillana.robotsdbpepe.adapter.RobotAdapter
import com.cantillana.robotsdbpepe.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        Log.i("","Iniciada vista recycler view")
        val admin=AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd=admin.writableDatabase
        val fila=bd.rawQuery("SELECT * FROM robots", null)
        val myRobotAdapter=RobotAdapter()
        myRobotAdapter.RobotAdapter(this, fila)
        binding.rcRobots.layoutManager=LinearLayoutManager(this)
        binding.rcRobots.adapter=myRobotAdapter
    }
}