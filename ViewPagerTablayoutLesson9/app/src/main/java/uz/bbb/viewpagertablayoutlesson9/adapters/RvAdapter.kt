package uz.bbb.viewpagertablayoutlesson9.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.bbb.viewpagertablayoutlesson9.R
import uz.bbb.viewpagertablayoutlesson9.databinding.ImageItemBinding


class RvAdapter(private val imageList: List<String>) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(url: String) {
            Picasso.get().load(url).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Vh(binding)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size
}
