package uz.bbb.android5lesson3.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.IntentCompat
import androidx.recyclerview.widget.RecyclerView
import uz.bbb.android5lesson3.SecondActivity
import uz.bbb.android5lesson3.databinding.ItemContactBinding
import uz.bbb.android5lesson3.models.Contact

class ContactAdapter(val contactList: List<Contact>, val onMyItemClickListener: OnMyItemClickListener) :
    RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder, position: Int
    ) {
        val contact: Contact = contactList[position]
        holder.onBind(contact,position)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class MyViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(contact: Contact,position: Int) {
            binding.name.text = contact.name
            binding.number.text = contact.number

            itemView.setOnClickListener {
                onMyItemClickListener.onMyItemClick(contact,position)
            }

//            itemView.setOnLongClickListener {
//                onMyItemClickListener.onMyItemLongClick(contact)
//                true
//            }

        }
    }

    interface OnMyItemClickListener {
        fun onMyItemClick(contact: Contact,position: Int)
       // fun onMyItemLongClick(contact: Contact)
    }
}