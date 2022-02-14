package fr.isen.demasithibault.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Button
import fr.isen.demasithibault.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : MenuActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuStarters = binding.starters
        val menuMainDish = binding.mainDish
        val menuDesserts = binding.desserts

        //To access to the starters of the menu of the API
        menuStarters.setOnClickListener{
            val category: String = menuStarters.getText().toString()
            Toast.makeText(this, "Vous êtes en train de visualiser les entrées", Toast.LENGTH_SHORT).show()
            Log.i("info", "end of activity")
            changeActivity(category)
        }

        //To access to the main dish of the menu of the API
        menuMainDish.setOnClickListener {
            val category: String = menuMainDish.getText().toString()
            Toast.makeText(this, "Vous êtes en train de visualiser les plats principaux", Toast.LENGTH_SHORT).show()
            Log.i("info", "end of activity")
            changeActivity(category)
        }

        //TO access to the desserts of the menu of the API
        menuDesserts.setOnClickListener {
            val category: String = menuDesserts.getText().toString()
            Toast.makeText(this, "Vous êtes en train de visualiser les desserts", Toast.LENGTH_SHORT).show()
            Log.i("info", "end of activity")
            changeActivity(category)
        }
    }

    private fun changeActivity(string: String) {
        val intent: Intent = Intent(this, ListActivity::class.java)
        intent.putExtra("category_type", string)
        startActivity(intent)
    }
}