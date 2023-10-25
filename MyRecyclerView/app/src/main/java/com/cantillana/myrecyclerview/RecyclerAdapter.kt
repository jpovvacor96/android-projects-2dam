package com.cantillana.myrecyclerview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cantillana.myrecyclerview.databinding.ItemAnimalListBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var animals:MutableList<MyAnimals> = ArrayList()

    lateinit var context: Context

    fun RecyclerAdapter(animalsList: MutableList<MyAnimals>, context: Context){
        this.animals=animalsList
        this.context=context
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private var binding = ItemAnimalListBinding.bind(view)

        fun bind(animal: MyAnimals, context: Context) {
            binding.tvNameAnimal.text = animal.animalName
            binding.tvLatinName.text = animal.latinName
            binding.ivAnimalImage.setImageResource(animal.imageAnimal)
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    /**
     * Método que le pasa los elementos al ViewHolder
     */
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    /**
     * Devuelve el tamaño del array
     */
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}