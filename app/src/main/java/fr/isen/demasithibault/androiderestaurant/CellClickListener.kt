package fr.isen.demasithibault.androiderestaurant

import fr.isen.demasithibault.androiderestaurant.model.DishModel

interface CellClickListener {
    fun onCellClickListener(data: DishModel)
}