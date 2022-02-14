package fr.isen.demasithibault.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.demasithibault.androiderestaurant.model.DishModel

class CustomAdapter(private val mList: List<DishModel>, private val cellClickListener: CellClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.design_for_list, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dish = mList[position]

        if(dish.image[0]!="") {
            Picasso.get()
                .load(dish.image[0])
                .error(R.drawable.error_foreground)
                .into(holder.itemImage)
        } else {
            holder.itemImage.setImageResource(R.drawable.error_foreground)
        }

        holder.itemText.text = dish.name_fr
        holder.itemPrice.text = dish.prices[0].price+"€"


        val data = mList[position]
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }

    }
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemText: TextView = itemView.findViewById(R.id.textView)
        val itemImage: ImageView = itemView.findViewById(R.id.imageview)
        val itemPrice: TextView = itemView.findViewById(R.id.price)
    }
}