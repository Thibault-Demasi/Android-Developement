package fr.isen.demasithibault.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button.setOnClickListener(R.layout.activity_home){
            Toast.makeText(applicationContext, "this is toast message", Toast.LENGTH_SHORT).show()

            val toast = Toast.makeText(applicationContext, "Hello javapoint", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}