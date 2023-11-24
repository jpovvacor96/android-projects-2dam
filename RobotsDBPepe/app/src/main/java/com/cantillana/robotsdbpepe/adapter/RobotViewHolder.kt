package com.cantillana.robotsdbpepe.adapter

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cantillana.robotsdbpepe.databinding.ItemRobotBinding
import com.bumptech.glide.Glide
import com.cantillana.robotsdbpepe.RobotDetailActivity

class RobotViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding=ItemRobotBinding.bind(view)

    fun render(cursorModel:Cursor, context: Context){
        binding.tvNombre.text=cursorModel.getString(1).toString()
        binding.tvEmail.text=cursorModel.getString(2).toString()
        var info=cursorModel.getString(3).toString()
        var foto=cursorModel.getString(4).toString()
        Glide.with(binding.ivFoto.context).load(foto).into(binding.ivFoto)
        binding.cvItem.setOnClickListener {
            val intento=Intent(context, RobotDetailActivity::class.java)
            intento.putExtra("nombre", binding.tvNombre.text)
            intento.putExtra("email", binding.tvEmail.text)
            intento.putExtra("info", info)
            intento.putExtra("foto", foto)
            context.startActivity(intento)
        }
    }
}