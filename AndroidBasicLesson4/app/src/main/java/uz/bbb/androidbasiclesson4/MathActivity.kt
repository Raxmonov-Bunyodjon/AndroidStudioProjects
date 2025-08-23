package uz.bbb.androidbasiclesson4

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MathActivity : AppCompatActivity() {
    val random = Random.Default
    lateinit var number1: TextView
    lateinit var number2: TextView
    lateinit var amal: TextView
    lateinit var next_btn: TextView
    lateinit var edit: TextView
    lateinit var imkoniyatlar: TextView
    lateinit var imkoniyatlar_qoldiq: TextView
    lateinit var togri_javob: TextView


    private var maxImkoniyat = 10      // umumiy imkoniyatlar
    private var qoldiqImkoniyat = 10   // qolgan imkoniyatlar
    private var qoldiqnatija = 0   // qolgan imkoniyatlar
    var result: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_math)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        amal = findViewById(R.id.amal)
        next_btn = findViewById(R.id.next_btn)
        edit = findViewById(R.id.edit)
        imkoniyatlar = findViewById(R.id.imkoniyatlar)
        imkoniyatlar_qoldiq = findViewById(R.id.imkoniyatlar_qoldiq)
        togri_javob = findViewById(R.id.togri_javob)

        imkoniyatlar.text = "Umumiy: $maxImkoniyat"
        imkoniyatlar_qoldiq.text = "Qoldiq: $qoldiqImkoniyat"
        togri_javob.text = "To'g'ri javob: $qoldiqnatija"



        setElements()

        next_btn.setOnClickListener {
            val myResult = edit.text.toString()

            if (myResult == result.toString()) {
                Toast.makeText(this, "✅ To'g'ri javob", Toast.LENGTH_SHORT).show()
                qoldiqnatija++
                togri_javob.text = "To'g'ri javob: $qoldiqnatija"
            } else {
                Toast.makeText(this, "❌ Noto'g'ri javob", Toast.LENGTH_SHORT).show()
                // noto‘g‘ri bo‘lsa bitta imkoniyat kamayadi
                qoldiqImkoniyat--
                imkoniyatlar_qoldiq.text = "Qoldiq: $qoldiqImkoniyat"

                if (qoldiqImkoniyat == 0) {
                    Toast.makeText(this, "❌ O'yin tugadi!", Toast.LENGTH_LONG).show()
                    next_btn.isEnabled = false   // tugma endi ishlamaydi
                    return@setOnClickListener
                }
            }

            edit.text = ""  // inputni tozalash
            setElements()
        }
    }

    fun setElements() {
        val son1 = random.nextInt(100)
        val son2 = random.nextInt(1, 100) // 0 bo‘lmasin, bo‘linishda xatolik bermasin
        number1.text = son1.toString()
        number2.text = son2.toString()
        result = null

        val n = random.nextInt(4)

        when (n) {
            0 -> {
                amal.text = "+"
                result = son1 + son2
            }

            1 -> {
                amal.text = "-"
                result = son1 - son2
            }

            2 -> {
                amal.text = "*"
                result = son1 * son2
            }

            3 -> {
                amal.text = "/"
                result = son1 / son2
            }
        }
    }
}