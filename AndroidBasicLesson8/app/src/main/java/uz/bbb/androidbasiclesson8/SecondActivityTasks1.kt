package uz.bbb.androidbasiclesson8

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import yuku.ambilwarna.AmbilWarnaDialog
import android.content.Intent

class SecondActivityTasks1 : AppCompatActivity() {
    private var defaultColor = Color.RED
    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_tasks1)

        layout = findViewById(R.id.mainLayout)
        val btnPick: Button = findViewById(R.id.btnPickColor)

        // 🔄 Agar rang avval saqlangan bo‘lsa, qayta tiklash
        if (savedInstanceState != null) {
            defaultColor = savedInstanceState.getInt("savedColor", Color.RED)
            layout.setBackgroundColor(defaultColor)
        }

        btnPick.setOnClickListener {
            val colorPicker = AmbilWarnaDialog(this, defaultColor,
                object : AmbilWarnaDialog.OnAmbilWarnaListener {
                    override fun onCancel(dialog: AmbilWarnaDialog) {}

                    override fun onOk(dialog: AmbilWarnaDialog, color: Int) {
                        defaultColor = color
                        layout.setBackgroundColor(color)

                        // Faqat natijani qaytaramiz
                        val resultIntent = Intent()
                        resultIntent.putExtra("selectedColor", color)
                        setResult(RESULT_OK, resultIntent)

                        // ❌ finish() ni olib tashladik — foydalanuvchi o‘zi BACK bosib chiqadi
                    }
                })
            colorPicker.show()
        }
    }

    // 📌 Rangni saqlab qo‘yish
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("savedColor", defaultColor)
    }
}

