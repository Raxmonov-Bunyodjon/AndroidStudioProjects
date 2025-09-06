package uz.bbb.viewpagertablayoutlesson9.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.bbb.viewpagertablayoutlesson9.SecondFragment
import uz.bbb.viewpagertablayoutlesson9.UserFragment
import uz.bbb.viewpagertablayoutlesson9.models.User

class UserPagerAdapter(val userList: List<User>, val titleList:List<String>, fragmentManager: FragmentManager) : FragmentStatePagerAdapter  (
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return UserFragment.newInstance(userList[position])
    }

    override fun getCount(): Int {
        return userList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

}