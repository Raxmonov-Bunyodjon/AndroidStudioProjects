package uz.bbb.viewpager2lesson10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var list: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        list = ArrayList()
        list.add("https://storage.kun.uz/source/thumbnails/_medium/11/ObTdlCRhnZ6NAuWUu3ECv8HY2FFxYmOg_medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/11/xDXIu5e9fDocQdvGhfPT1gOU9PCvlMR__medium.jpg")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/11/zg_DOougtx4rxbXwSOox8Mt7TTlN04YM_medium.jpg")
    }
}