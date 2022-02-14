package fr.isen.demasithibault.androiderestaurant

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.demasithibault.androiderestaurant.model.DishBasket

class BasketAdapter(private val List: List<DishBasket>, private val cellClickListener: CellClickListener): RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.design_for_list, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = List[position]
        if(dish.itemDish.images[0]!=""){
            Picasso.get()
                .load(dish.itemDish.images[0])
                .error(R.mipmap.erreur404_foreground)
                .into(holder.basketImage)
        } else {
            holder.basketImage.setImageResource(R.mipmap.erreur404_foreground)
        }

        val totalPrice = (dish.itemDish.prices[0].price).toFloat()*dish.quantity.toFloat()
        holder.basketText.text = dish.quantity.toString() + " " + dish.itemDish.name_fr
        holder.basketPrice.text = totalPrice.toString() + "€"
        holder.basketBin.setOnClickListener{
            cellClickListener.onCellClickListenerBasket(dish)
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }



    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val basketImage: ImageView = itemView.findViewById(R.id.imageview)
        val basketText: TextView = itemView.findViewById(R.id.textView)
        val basketPrice: TextView = itemView.findViewById(R.id.price)
        val basketBin: ImageView = itemView.findViewById(R.id.bin)
    }
}