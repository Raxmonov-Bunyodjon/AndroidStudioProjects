package uz.bbb.phoneapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PhoneTypes : AppCompatActivity() {
    private val brands = listOf("Pixel", "iPhone", "Samsung", "Mi", "Huawei", "Artel")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_phone_types)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val models = listOf("Pixel", "iPhone", "Samsung", "Mi", "Huawei", "Artel")

        val grid = findViewById<GridView>(R.id.gridModels)
        val adapter = ArrayAdapter(this, R.layout.item_model, R.id.modelName, models)
        grid.adapter = adapter

        grid.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, AddPhoneBrandActivity::class.java)
            intent.putExtra("model", models[position])
            startActivity(intent)
        }
    }
}