package uz.bbb.android5lesson4.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.bbb.android5lesson4.databinding.ItemUserBinding
import uz.bbb.android5lesson4.models.User

class UserAdapter: ListAdapter<User, UserAdapter.Vh>(MyDiffUtill()) {
    inner class Vh(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root
    ) {
        fun onBind(user: User){

            binding.tv1.text = user.username
            binding.tv2.text = user.password
        }
    }
    class MyDiffUtill: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(
            oldItem: User,
            newItem: User
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: User,
            newItem: User
        ): Boolean {
            return oldItem.equals(newItem)
        }}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Vh {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Vh(binding)
    }

    override fun onBindViewHolder(
        holder: Vh,
        position: Int
    ) {
        val user:User = getItem(position)
        holder.onBind(user)
    }



    }


