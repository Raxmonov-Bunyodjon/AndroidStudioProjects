package uz.bbb.listview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import uz.bbb.listview.R
import uz.bbb.listview.models.ImageData

class ImageBaseAdapter(private val list: List<ImageData>,
                       private val context: Context
): BaseAdapter() {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): ImageData = list[position]


    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        } else {
            itemView = convertView
        }

        val imageView = itemView.findViewById<ImageView>(R.id.image_view)
        val textView = itemView.findViewById<TextView>(R.id.tv)

        val data = list[position]

        // ✅ Picasso orqali rasmni yuklash
        Picasso.get().load(data.imgUrl).into(imageView)

        // ✅ Matn qo‘yish
        textView.text = data.text

        return itemView
    }
}