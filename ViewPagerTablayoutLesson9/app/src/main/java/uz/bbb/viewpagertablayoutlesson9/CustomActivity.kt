package uz.bbb.viewpagertablayoutlesson9

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import uz.bbb.viewpagertablayoutlesson9.adapters.CategoryAdapter
import uz.bbb.viewpagertablayoutlesson9.databinding.ActivityCustomBinding
import uz.bbb.viewpagertablayoutlesson9.models.Category
import java.util.Locale

class CustomActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCustomBinding

    lateinit var categoryList: ArrayList<Category>
    lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_custom)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imageList = ArrayList<String>()
        for (i in 0..100) {
            imageList.add("https://www.seekpng.com/png/small/50-503873_facebook-teerasej-profile-ball-circle-facebook-profile-picture.png")
        }
        categoryList = ArrayList()
        categoryList.add(Category("All", imageList))
        categoryList.add(Category("New", imageList))
        categoryList.add(Category("Animals", imageList))
        categoryList.add(Category("Technology", imageList))
        categoryList.add(Category("Nature", imageList))

        categoryAdapter = CategoryAdapter(categoryList, supportFragmentManager)
        binding.viewPager.adapter = categoryAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }

}