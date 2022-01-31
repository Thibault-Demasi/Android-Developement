package fr.isen.demasithibault.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Button
import fr.isen.demasithibault.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.starter.setOnClickListener {
            Toast.makeText(this, "Tu as cliqué sur Entrées", Toast.LENGTH_LONG).show()
            changeActivity(getString(R.string.home_starter))
        }

        binding.dish.setOnClickListener {
            Toast.makeText(this, "Tu as cliqué sur Plats", Toast.LENGTH_LONG).show()
            changeActivity(getString(R.string.home_dish))
        }

        binding.dessert.setOnClickListener {
            Toast.makeText(this, "Tu as cliqué sur Desserts", Toast.LENGTH_LONG).show()
            changeActivity(getString(R.string.home_desserts))
        }

    }

    private fun changeActivity(category: String) {
        val changePage = Intent(this, ListActivity::class.java)
        changePage.putExtra("category_type", category)
        startActivity(changePage)
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeActivity", "Vous stoppez la page home")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "Vous quittez la page home")
    }

    companion object {
        const val CATEGORY_NAME = "CATEGORY_NAME"
    }
}