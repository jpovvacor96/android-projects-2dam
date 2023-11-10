package com.cantillana.myrobots.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cantillana.myrobots.Robot
import com.bumptech.glide.Glide
import com.cantillana.myrobots.ItemRobotDetailActivity
import com.cantillana.myrobots.databinding.ItemRobotBinding

class RobotViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding=ItemRobotBinding.bind(view)

    fun render(robotModel: Robot, context: Context){
        binding.tvNombre.text=robotModel.nombre
        binding.tvApodo.text=robotModel.apodo
        Glide.with(binding.ivFoto.context).load(robotModel.foto).into(binding.ivFoto)
        binding.cvItem.setOnClickListener{
            val intento=Intent(context, ItemRobotDetailActivity::class.java)
            intento.putExtra("nombre", robotModel.nombre)
            intento.putExtra("apodo", robotModel.apodo)
            intento.putExtra("foto", robotModel.foto)
            intento.putExtra("info", robotModel.info)
            context.startActivity(intento)
        }
    }

}