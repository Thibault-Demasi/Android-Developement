package fr.isen.demasithibault.androiderestaurant

import fr.isen.demasithibault.androiderestaurant.model.DishModel
import fr.isen.demasithibault.androiderestaurant.model.ItemsViewModel

interface CellClickListener {
    fun onCellClickListener(data: DishModel)
}