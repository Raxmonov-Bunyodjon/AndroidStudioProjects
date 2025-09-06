package uz.bbb.viewpagertablayoutlesson9.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso

import uz.bbb.viewpagertablayoutlesson9.databinding.ItemViewPagerBinding

class ImageAdapter(var imageList:List<String>): PagerAdapter() {

    private var inflater: LayoutInflater? = null
    override fun getCount(): Int = imageList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Binding orqali layoutni bog‘lash
        val binding = ItemViewPagerBinding.inflate(LayoutInflater.from(container.context), container, false)

        // Rasm yuklash
        Picasso.get().load(imageList[position]).into(binding.image)

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)

    }
}