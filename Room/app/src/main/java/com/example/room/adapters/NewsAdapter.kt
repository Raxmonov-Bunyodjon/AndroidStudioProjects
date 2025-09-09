package com.example.room.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.ItemNewsBinding
import com.example.room.entity.CategoryNews
import com.example.room.entity.News

class NewsAdapter(
    var list: List<News>,
    var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<NewsAdapter.Vh>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    inner class Vh(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: News, position: Int) {
            binding.tv1.text = news.title
            binding.tv2.text = news.desc

            binding.deleteBtn.setOnClickListener {
                onItemClickListener.onItemDelete(news, position)
            }
            binding.editBtn.setOnClickListener {
                onItemClickListener.onItemEdit(news, position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemDelete(news: News, position: Int)
        fun onItemEdit(news: News, position: Int)
    }
}