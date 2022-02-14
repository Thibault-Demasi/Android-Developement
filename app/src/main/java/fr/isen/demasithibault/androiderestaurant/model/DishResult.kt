package fr.isen.demasithibault.androiderestaurant.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DishResult(val data: List<CategoryModel>): Serializable

data class CategoryModel(val name_fr: String, val items: List<DishModel>): Serializable

data class DishModel(val name_fr: String, @SerializedName("images") val image: List<String>, val prices: List<PriceModel>,val ingredients: List<IngredientModel>): Serializable {
    fun getFirstPicture() = image[0]
}

data class PriceModel (val price: String) : Serializable

data class IngredientModel(val name_fr: String): Serializable
