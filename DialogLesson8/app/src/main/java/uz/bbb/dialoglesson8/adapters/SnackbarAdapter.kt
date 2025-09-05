package uz.bbb.dialoglesson8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bbb.dialoglesson8.databinding.UserItemBinding

class SnackbarAdapter(var list: List<String>, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<SnackbarAdapter.Vh>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Vh(binding)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    inner class Vh(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(str: String,position: Int) {
            binding.tv.text = str

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(str, position, itemView)
            }
        }
    }


    interface OnItemClickListener{
        fun onItemClick(str:String,position: Int, ItemView: View)
    }
}
