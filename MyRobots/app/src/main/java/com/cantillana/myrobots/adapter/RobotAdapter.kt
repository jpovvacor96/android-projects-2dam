package com.cantillana.myrobots.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cantillana.myrobots.R
import com.cantillana.myrobots.Robot

class RobotAdapter(private val context:Context, private val robotList: List<Robot>):
    RecyclerView.Adapter<RobotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RobotViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return RobotViewHolder(layoutInflater.inflate(R.layout.item_robot, parent, false))
    }

    override fun getItemCount(): Int {
        return robotList.size
    }

    override fun onBindViewHolder(holder: RobotViewHolder, position: Int) {
        val item=robotList[position]
        holder.render(item, context)
    }

}