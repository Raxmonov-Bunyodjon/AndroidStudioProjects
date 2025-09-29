package uz.bbb.listview

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.bbb.listview.adapters.ImageBaseAdapter
import uz.bbb.listview.models.ImageData

class MainActivity : AppCompatActivity() {
    val list = ArrayList<ImageData>()
    lateinit var imageBaseAdapter: ImageBaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.grid_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val grid_view = findViewById<GridView>(R.id.grid_view)

        loadData()

        imageBaseAdapter = ImageBaseAdapter(list, this)
        grid_view.adapter = imageBaseAdapter


        grid_view.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("image", list[position])
            startActivity(intent)
        }



    }

    private fun loadData() {
        for (i: Int in 0..100){
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","Kotlin"))
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","Android"))
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","Java"))
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","Flutter"))
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","React"))
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","JS"))
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","Python"))
        list.add(ImageData("https://storage.kun.uz/source/11/F58y1dInbe0zCCyqFK6g46Rd8w5UZaou.jpg","C++"))
        }
    }
}