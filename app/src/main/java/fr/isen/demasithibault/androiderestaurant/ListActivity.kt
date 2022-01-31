package fr.isen.demasithibault.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.demasithibault.androiderestaurant.databinding.ActivityListBinding
import fr.isen.demasithibault.androiderestaurant.model.DishModel
import fr.isen.demasithibault.androiderestaurant.model.DishResult
import org.json.JSONObject


class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var category: String? = ""
        if (intent.hasExtra("selectedCategory")) {
            category = intent.getStringExtra("selectedCategory")
        }
        val textViewCategory = binding.lunchTitle
        textViewCategory.setText(category)

        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")

        val request = JsonObjectRequest(
            Request.Method.POST, url, jsonObject,
            { response ->

                var gson = Gson()
                var dishresult = gson.fromJson(response.toString(), DishResult::class.java)
                displayDishes(dishresult.data.firstOrNull { it.name_fr == category }?.items ?: listOf())

                //textView.text = "Response: ${dishresult.data[1].items[0].name_fr}"
                Log.d("", "$response")
            }, {
                // Error in request
                Log.i("","Volley error: $it")
            })

        // Volley request policy, only one time request to avoid duplicate transaction
        request.retryPolicy = DefaultRetryPolicy(
            DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
            // 0 means no retry
            0, // DefaultRetryPolicy.DEFAULT_MAX_RETRIES = 2
            1f // DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        // Add the volley post request to the request queue
        queue.add(request)


    }

    private fun displayDishes (dishresult: List<DishModel>){
        // getting the recyclerview by its id
        val recyclerview = binding.recyclerView

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)


        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(dishresult, this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }


    override fun onCellClickListener(data: DishModel) {
        val monIntent: Intent =  Intent(this, DetailActivity::class.java)
        monIntent.putExtra("itemDish", data)



        startActivity(monIntent)
    }


}