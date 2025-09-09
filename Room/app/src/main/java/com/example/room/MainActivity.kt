package com.example.room

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.room.adapters.CategoryAdapter
import com.example.room.adapters.NewsAdapter
import com.example.room.database.AppDatabase
import com.example.room.databinding.ActivityMainBinding
import com.example.room.databinding.DialogBinding
import com.example.room.entity.Category
import com.example.room.entity.News

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var appDatabase: AppDatabase

    lateinit var list: ArrayList<News>

    lateinit var newsAdapter: NewsAdapter

    lateinit var categoryList: ArrayList<Category>

    lateinit var categoryAdapter:CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        appDatabase = AppDatabase.getInstance(this)
//        val category1 = Category("Dunyo")
//        val category2 = Category("Texnologiya")
//        val category3 = Category("Mahalliy")
//        appDatabase.categoryDao().insertAllCategory(category1,category2,category3)

        categoryList = ArrayList()
        categoryList.addAll(appDatabase.categoryDao().getAllCategories())

        categoryAdapter = CategoryAdapter(categoryList)
        binding.spinner.adapter = categoryAdapter




        list = ArrayList()
        list.addAll(appDatabase.newsDao().getAllNews())

        newsAdapter = NewsAdapter(list, object : NewsAdapter.OnItemClickListener {
            override fun onItemDelete(news: News, position: Int) {
                appDatabase.newsDao().deleteNews(news)
                list.remove(news)
                newsAdapter.notifyItemRemoved(position)
                newsAdapter.notifyItemRangeChanged(position, list.size - 1)
            }

            override fun onItemEdit(news: News, position: Int) {
                val dialog = AlertDialog.Builder(this@MainActivity)
                val dialogBinding = DialogBinding.inflate(layoutInflater)
                dialog.setView(dialogBinding.root)
                dialogBinding.titleEt.setText(news.title)
                dialogBinding.descEt.setText(news.desc)

                dialog.setPositiveButton("Ok") { dialog, which ->
                    val title1 = dialogBinding.titleEt.text.toString()
                    val desc1 = dialogBinding.descEt.text.toString()
                    news.title = title1
                    news.desc = desc1
                    appDatabase.newsDao().updateNews(news)
                    newsAdapter.notifyItemChanged(position)
                }
                dialog.show()
            }
        })

        binding.rv.adapter = newsAdapter

        binding.addBtn.setOnClickListener {
            val title = binding.edit1.text.toString()
            val desc = binding.edit2.text.toString()
            val news = News()
            news.title = title
            news.desc = desc
            val selectedItemPosition = binding.spinner.selectedItemPosition
            val category = categoryList[selectedItemPosition]
            news.categoryId = category.id


            appDatabase.newsDao().addNews(news)
            val id = appDatabase.newsDao().getNewsById(title, desc)
            news.id = id
            list.add(news)
            newsAdapter.notifyItemInserted(list.size)

        }
    }
}