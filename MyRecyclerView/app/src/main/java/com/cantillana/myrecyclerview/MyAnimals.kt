package com.cantillana.myrecyclerview

data class MyAnimals(val name:String, val latin:String, val image:Int){

    var animalName: String?=null
    var latinName: String?=null
    var imageAnimal: Int=0

    init {
        this.animalName=name
        this.latinName=latin
        this.imageAnimal=image
    }
}
