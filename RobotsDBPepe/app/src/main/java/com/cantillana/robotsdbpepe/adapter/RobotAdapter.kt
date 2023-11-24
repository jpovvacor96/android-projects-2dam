package com.cantillana.robotsdbpepe.adapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cantillana.robotsdbpepe.R

class RobotAdapter:RecyclerView.Adapter<RobotViewHolder>() {

    private lateinit var context: Context

    private lateinit var cursor: Cursor

    fun RobotAdapter(context: Context, cursor: Cursor){
        this.context=context
        this.cursor=cursor
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RobotViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return RobotViewHolder(layoutInflater.inflate(R.layout.item_robot, parent, false))
    }
    override fun getItemCount(): Int {
        return cursor.count
    }
    override fun onBindViewHolder(holder: RobotViewHolder, position: Int) {
        cursor.moveToPosition(position)
        holder.render(cursor, context)
    }
}