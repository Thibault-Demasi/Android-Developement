package fr.isen.demasithibault.androiderestaurant

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var buttonAppetizer = findViewById(R.id.button) as Button

        buttonAppetizer.setOnClickListener {
            // make a toast on button click event
            Toast.makeText(this, "Tu as cliqué sur Entrées", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ListActivity ::class.java)
            startActivity(intent)
            finish()
            Log.d(TAG, "onDestroy() est appelé")
        }

        var bouttonMainCourse = findViewById(R.id.button2) as Button

        bouttonMainCourse.setOnClickListener {
            // make a toast on button click event
            Toast.makeText(this, "Tu as cliqué sur Plats", Toast.LENGTH_LONG).show()
        }

        var bouttonDesserts = findViewById(R.id.button3) as Button

        bouttonDesserts.setOnClickListener {
            // make a toast on button click event
            Toast.makeText(this, "Tu as cliqué sur Desserts", Toast.LENGTH_LONG).show()
        }
    }
}