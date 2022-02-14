package fr.isen.demasithibault.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import fr.isen.demasithibault.androiderestaurant.model.ItemsViewModel
import com.squareup.picasso.Picasso
import fr.isen.demasithibault.androiderestaurant.model.DishModel

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //var item: String? = ""

        val itemDish = intent.getSerializableExtra("itemDish") as DishModel

        val detailTitle = findViewById<TextView>(R.id.mealTitle)
        detailTitle.setText(itemDish.name_fr)
        val detailImage = findViewById<ImageView>(R.id.mealImage)
        if(itemDish.image[0]!="") {
            Picasso.get()
                .load(itemDish.image[0])
                .error(R.drawable.error_foreground)
                .into(detailImage)
        } else{
            detailImage.setImageResource(R.drawable.error_foreground)
        }

        val detail = findViewById<TextView>(R.id.mealDetail)
        detail.setText(itemDish.name_fr)

        val detailPrice = findViewById<TextView>(R.id.mealPrice)
        detailPrice.setText(itemDish.prices[0].price + "€")

        for (i in itemDish.ingredients)
            detail.append(i.name_fr + " ")

    }
}