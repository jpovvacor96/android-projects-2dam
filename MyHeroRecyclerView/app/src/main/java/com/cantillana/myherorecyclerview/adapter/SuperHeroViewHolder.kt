package com.cantillana.myherorecyclerview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cantillana.myherorecyclerview.SuperHero
import com.cantillana.myherorecyclerview.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding=ItemSuperheroBinding.bind(view)

    fun render(superheroModel: SuperHero){
        binding.tvName.text=superheroModel.superhero
        binding.tvRealName.text=superheroModel.realName
        binding.tvPublisher.text=superheroModel.publisher
        Glide.with(binding.ivSuperHero.context).load(superheroModel.photo).into(binding.ivSuperHero)

        //binding al item view set onclicklistener
        //val intento2=Intent()


    }

}