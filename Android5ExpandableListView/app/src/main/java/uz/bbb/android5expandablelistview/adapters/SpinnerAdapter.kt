package uz.bbb.android5expandablelistview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import uz.bbb.android5expandablelistview.R
import uz.bbb.android5expandablelistview.models.User

class SpinnerAdapter(var list:List<User>): BaseAdapter() {


    override fun getCount(): Int {
        return list.size
    }
    override fun getItem(position: Int): User? {
        return list[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        // Spinner item ichidagi viewlarni chaqiramiz

        val itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.spinner_item, parent, false)
        } else {
            itemView = convertView
        }

        // Spinner item ichidagi viewlarni chaqiramiz
        val imageView = itemView.findViewById<ImageView>(R.id.image)
        val textView = itemView.findViewById<TextView>(R.id.spinner_tv)

        // Ma'lumotlarni o‘rnatamiz
        imageView.setImageResource(list[position].img)
        textView.text = list[position].name

        return itemView
    }



}