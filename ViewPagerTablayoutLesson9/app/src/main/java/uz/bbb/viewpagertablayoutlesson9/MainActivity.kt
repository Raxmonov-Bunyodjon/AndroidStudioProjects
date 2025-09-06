package uz.bbb.viewpagertablayoutlesson9

import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ToxicBakery.viewpager.transforms.*
import uz.bbb.viewpagertablayoutlesson9.adapters.UserPagerAdapter
import uz.bbb.viewpagertablayoutlesson9.databinding.ActivityMainBinding
import uz.bbb.viewpagertablayoutlesson9.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var userList: ArrayList<User>
    lateinit var titleList: ArrayList<String>

    lateinit var handler: Handler
    lateinit var userPagerAdapter: UserPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ✅ Binding init
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userList = ArrayList()
        for (i: Int in 1..100) {
            userList.add(
                User(
                    "Bunyod Raxmonov",
                    "https://www.seekpng.com/png/small/50-503873_facebook-teerasej-profile-ball-circle-facebook-profile-picture.png"
                )
            )
            userList.add(
                User(
                    "Bunyod Raxmonov",
                    "https://www.seekpng.com/png/small/50-503873_facebook-teerasej-profile-ball-circle-facebook-profile-picture.png"
                )
            )
            userList.add(
                User(
                    "Bunyod Raxmonov",
                    "https://www.seekpng.com/png/small/50-503873_facebook-teerasej-profile-ball-circle-facebook-profile-picture.png"
                )
            )
        }
        titleList = ArrayList()
        for (i: Int in 1..100) {
            titleList.add("Home")
            titleList.add("About us")
            titleList.add("Contact us")
        }
        userPagerAdapter = UserPagerAdapter(userList, titleList, supportFragmentManager)
        binding.viewPager.setPageTransformer(true,TabletTransformer())
        binding.viewPager.adapter = userPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        handler = Handler()

        handler.postDelayed(runnable, 2000)
    }

    var runnable = object: Runnable{
        override fun run() {
            binding.viewPager.currentItem+=1
            handler.postDelayed(this,2000)
        }
    }
}


