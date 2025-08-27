package uz.bbb.androidbasiclesson8

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivityTasks1 : AppCompatActivity() {
    private lateinit var layout: LinearLayout
    private var selectedColor: Int? = null

    // 2-activitydan natija olish uchun launcher
    private val colorPickerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val color = result.data?.getIntExtra("selectedColor", -1)
            if (color != null && color != -1) {
                selectedColor = color
                layout.setBackgroundColor(color) // 🎨 rangni qo‘llash
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tasks1)

        layout = findViewById(R.id.main)
        val btn: Button = findViewById(R.id.first_button)

        btn.setOnClickListener {
            val intent = Intent(this, SecondActivityTasks1::class.java)
            colorPickerLauncher.launch(intent)
        }

        // ✅ Agar oldin saqlangan rang bo‘lsa tiklaymiz
        if (savedInstanceState != null) {
            selectedColor = savedInstanceState.getInt("selectedColor", Color.WHITE)
            layout.setBackgroundColor(selectedColor!!)
        }
    }

    // 📌 Activity o‘chib ketayotganda rangni saqlash
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        selectedColor?.let { outState.putInt("selectedColor", it) }
    }

    // 📌 Activity qayta ochilganda rangni tiklash
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        selectedColor = savedInstanceState.getInt("selectedColor", Color.WHITE)
        layout.setBackgroundColor(selectedColor!!)
    }
}
