package fr.isen.demasithibault.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import fr.isen.demasithibault.androiderestaurant.model.ItemsViewModel

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var item: String? = ""

        val itemDish = intent.getSerializableExtra("itemDish") as ItemsViewModel

        val detail_title = findViewById<TextView>(R.id.mealTitle)
        detail_title.setText(itemDish.text)
        val detail_image = findViewById<ImageView>(R.id.mealImage)
        detail_image.setImageResource(itemDish.image)
        val detail_detail = findViewById<TextView>(R.id.mealDetail)
        detail_detail.setText(itemDish.detail)

    }
}