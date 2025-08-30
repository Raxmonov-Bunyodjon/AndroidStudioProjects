package uz.bbb.phoneapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class PhonesVersion : AppCompatActivity() {

    private val phoneModels = mapOf(
        "Pixel" to listOf(
            "Pixel 10 Pro XL",
            "Pixel 10 Pro",
            "Pixel 10",
            "Pixel 9 Pro Fold",
            "Pixel 9 Pro XL",
            "Pixel 9 Pro",
            "Pixel 9",
            "Pixel 9a",
            "Pixel 8 Pro",
            "Pixel 8"
        ),
        "iPhone" to listOf(
            "iPhone 16 Pro Max",
            "iPhone 16 Pro",
            "iPhone 16",
            "iPhone 15 Pro Max",
            "iPhone 15 Pro",
            "iPhone 15",
            "iPhone 14 Pro Max",
            "iPhone 14 Pro",
            "iPhone 14",
            "iPhone 13 Pro Max",
            "iPhone 13 Pro",
            "iPhone 13"
        ),
        "Samsung" to listOf(
            "Galaxy S23 Ultra",
            "Galaxy S22",
            "Galaxy S21 Ultra",
            "Galaxy S21",
            "Galaxy S20 Ultra",
            "Galaxy S20",
            "Galaxy Note 20",
            "Galaxy Note 10",
            "Galaxy S10 Plus",
            "Galaxy S10"
        ),
        "Mi" to listOf(
            "Redmi Note 12 Pro",
            "Redmi Note 11",
            "Redmi Note 10",
            "Mi 12 Pro",
            "Mi 12",
            "Mi 11 Lite",
            "Mi 11 Ultra",
            "Mi 11",
            "Mi 10 Pro",
            "Mi 10"
        ),
        "Huawei" to listOf(
            "P20",
            "P20 Pro",
            "Mate 20 Pro",
            "P30",
            "P30 Pro",
            "Mate 30 Pro",
            "P40",
            "P40 Pro",
            "Mate 40",
            "Mate 40 Pro"
        ),
        "Artel" to listOf(
            "Artel A10",
            "Artel A9",
            "Artel A8",
            "Artel A7",
            "Artel A6",
            "Artel A5",
            "Artel A4",
            "Artel A3",
            "Artel A2",
            "Artel A1"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_phones_version)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val brand = intent.getStringExtra("brand") ?: "Unknown"
        val models = phoneModels[brand] ?: listOf("No models found")

        val title = findViewById<TextView>(R.id.phone_version)
        title.text = brand

        val grid = findViewById<GridView>(R.id.gridModels)
        val adapter = ArrayAdapter(this, R.layout.item_model, R.id.modelName, models)
        grid.adapter = adapter

        grid.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, PhoneInfo::class.java)
            intent.putExtra("brand", brand)
            intent.putExtra("model", models[position])
            startActivity(intent)
        }

        }
    }
