package fr.isen.demasithibault.androiderestaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import fr.isen.demasithibault.androiderestaurant.databinding.ActivityBasketBinding
import fr.isen.demasithibault.androiderestaurant.model.DishBasket
import fr.isen.demasithibault.androiderestaurant.model.DishModel
import fr.isen.demasithibault.androiderestaurant.model.SavedDishBasket
import java.io.File

class BasketActivity : AppCompatActivity(), CellClickListener {
    private lateinit var binding: ActivityBasketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var filename = "/basket.json"
        var file = File(cacheDir.absolutePath + filename)

        if(file.exists()){
            val content = Gson().fromJson(file.readText(), SavedDishBasket::class.java)
            displayBasket(content.list)
        }

        binding.order.setOnClickListener{
            val userID = getSharedPreferences("IdSaving", Context.MODE_PRIVATE).getString("mail", "").toString()

            if(userID != ""){
                val intent: Intent = Intent(this, AuthenticationActivity::class.java)
                intent.putExtra("id_user", userID)
                startActivity(intent)
            } else {
                val intent: Intent = Intent(this, AuthenticationActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun displayBasket(dishBasket: ArrayList<DishBasket>){
        val recyclerView = binding.recyclerViewBasket
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = BasketAdapter(dishBasket, this)
        recyclerView.adapter = adapter
    }

    override fun onCellClickListener(data: DishModel) {
    }

    override fun onCellClickListenerBasket(data: DishBasket) {
        var filename = "/backet.json"
        var file = File(cacheDir.absolutePath + filename)
        val content = Gson().fromJson(file.readText(), SavedDishBasket::class.java)
        content.list.remove(
            DishBasket(data.itemDish, data.quantity)
        )
        file.writeText(Gson().toJson(SavedDishBasket(content.list)))
        displayBasket(content.list)
    }
}