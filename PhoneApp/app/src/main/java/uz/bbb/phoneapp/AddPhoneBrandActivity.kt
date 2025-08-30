package uz.bbb.phoneapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddPhoneBrandActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_phone)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Intent orqali brand nomini olish
        val brand = intent.getStringExtra("brand") ?: "Unknown"

        val nameInput = findViewById<EditText>(R.id.etPhoneName)
        val featuresInput = findViewById<EditText>(R.id.etPhoneFeatures)
        val addButton = findViewById<Button>(R.id.btnAdd)

        val dataStore = DataStoreManager(this)

        addButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val features = featuresInput.text.toString().trim()

            if (name.isEmpty() || features.isEmpty()) {
                Toast.makeText(this, "Iltimos, barcha maydonlarni to‘ldiring", Toast.LENGTH_SHORT)
                    .show()
            } else {
                lifecycleScope.launch {
                    // 🔥 Yangi metod chaqirilmoqda
                    dataStore.savePhoneToBrand(brand, name, features)

                    Toast.makeText(
                        this@AddPhoneBrandActivity,
                        "$name ($brand) qo‘shildi!",
                        Toast.LENGTH_LONG
                    ).show()

                    nameInput.text.clear()
                    featuresInput.text.clear()
                }
            }
        }
    }
}
