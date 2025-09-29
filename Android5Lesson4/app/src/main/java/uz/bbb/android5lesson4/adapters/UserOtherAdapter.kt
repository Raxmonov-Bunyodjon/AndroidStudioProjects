package uz.bbb.android5lesson4.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.bbb.android5lesson4.R
import uz.bbb.android5lesson4.databinding.ItemUserBinding
import uz.bbb.android5lesson4.models.User
import uz.bbb.android5lesson4.utils.ItemTouchHelperAdapter
import java.util.Collections

class UserOtherAdapter(var context: Context, var userList: ArrayList<User>) :
    RecyclerView.Adapter<UserOtherAdapter.Vh>(), ItemTouchHelperAdapter {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Vh {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Vh(binding)
    }

    override fun onBindViewHolder(
        holder: Vh,
        position: Int
    ) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size
    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(userList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(userList, i,i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        userList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class Vh(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User) {
            binding.tv1.text = user.username
            binding.tv2.text = user.password

            itemView.animation = AnimationUtils.loadAnimation(context, R.anim.anim4)
        }

    }
}