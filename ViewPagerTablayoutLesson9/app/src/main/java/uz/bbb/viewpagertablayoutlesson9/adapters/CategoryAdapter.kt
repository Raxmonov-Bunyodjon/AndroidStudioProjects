package uz.bbb.viewpagertablayoutlesson9.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.bbb.viewpagertablayoutlesson9.CategoryFragment
import uz.bbb.viewpagertablayoutlesson9.models.Category

class CategoryAdapter(var categoryList: List<Category>, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment  {
        return CategoryFragment.newInstance(categoryList[position].imageList)
    }

    override fun getCount(): Int {
        return categoryList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return categoryList[position].title
    }
}