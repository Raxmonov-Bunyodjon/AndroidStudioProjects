package uz.bbb.phoneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAddPhones = findViewById<Button>(R.id.btnAddPhones)
        val btnPhone = findViewById<Button>(R.id.btnPhone)

        btnPhone.setOnClickListener {
            startActivity(Intent(this, PhonesActivity::class.java))
        }

        btnAddPhones.setOnClickListener {
            startActivity(Intent(this, PhoneTypes::class.java))
        }
    }
}