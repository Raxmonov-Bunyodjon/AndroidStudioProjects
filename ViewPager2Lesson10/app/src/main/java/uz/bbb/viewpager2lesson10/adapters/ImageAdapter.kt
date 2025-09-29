package uz.bbb.viewpager2lesson10.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bbb.viewpager2lesson10.R

class ImageAdapter(var list:List<String>): RecyclerView.Adapter<ImageAdapter.Vh>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent, false))   }

    override fun onBindViewHolder(
        holder: Vh,
        position: Int
    ) {

    }

    override fun getItemCount(): Int = list.size

    inner class Vh(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}