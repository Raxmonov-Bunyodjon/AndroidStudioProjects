package uz.bbb.androidbasiclesson4

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TestQuestionActivity : AppCompatActivity() {

    data class Question(
        val text: String,
        val options: List<String>,
        val correctAnswer: Int // index (0=A, 1=B, 2=C, 3=D)
    )

    private lateinit var questionText: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var optionA: RadioButton
    private lateinit var optionB: RadioButton
    private lateinit var optionC: RadioButton
    private lateinit var optionD: RadioButton
    private lateinit var nextBtn: Button
    private lateinit var scoreText: TextView

    private var currentIndex = 0
    private var score = 0

    // 🔥 Kotlin bo‘yicha 10 ta savol
    private val questions = listOf(
        Question("Kotlinda `val` va `var` o‘rtasidagi asosiy farq nima?",
            listOf("val o‘zgaruvchi, var esa konstantadir",
                "val bir marta qiymat oladi, var esa o‘zgarishi mumkin",
                "val faqat sinflarda ishlatiladi",
                "var faqat funksiya ichida ishlatiladi"), 1),

        Question("Quyidagi kod natijasi nima bo‘ladi?\nval x = 5\nval y = 2\nprintln(x / y)",
            listOf("2", "2.5", "5", "0"), 0),

        Question("Kotlinda `fun` kalit so‘zi nimani bildiradi?",
            listOf("Obyekt e’lon qilish", "Funksiya e’lon qilish", "Klass e’lon qilish", "Konstruktor yaratish"), 1),

        Question("Kotlinda `when` operatori nimaga o‘xshash?",
            listOf("for loop", "switch-case", "if-else", "try-catch"), 1),

        Question("Kotlinda `companion object` nimaga kerak?",
            listOf("Global o‘zgaruvchi yaratish uchun",
                "Klass darajasidagi funksiyalar va qiymatlar uchun",
                "Ob’ektlarni solishtirish uchun",
                "Funksiyani chaqirish uchun"), 1),

        Question("Kotlinda extension function qanday yoziladi?",
            listOf("Klass ichida fun bilan",
                "Oddiy fun lekin oldiga klass nomi qo‘yiladi",
                "extend so‘zi bilan",
                "addFunction bilan"), 1),

        Question("Kotlinda `data class` nima vazifani bajaradi?",
            listOf("UI yaratish uchun ishlatiladi",
                "Ma’lumot saqlash va avtomatik toString, equals, hashCode beradi",
                "Har doim abstract bo‘ladi",
                "Hech qanday qo‘shimcha vazifasi yo‘q"), 1),

        Question("Quyidagi kodda qaysi chiqadi?\nval list = listOf(1, 2, 3)\nprintln(list[1])",
            listOf("1", "2", "3", "Error"), 1),

        Question("Kotlinda `sealed class` nimaga ishlatiladi?",
            listOf("Bir nechta faylni yopish uchun",
                "Cheklangan turdagi voris sinflar yaratish uchun",
                "Funksiya yopilishi uchun",
                "Faqat interface bilan ishlash uchun"), 1),

        Question("Quyidagi kod natijasi nima bo‘ladi?\nval name: String? = null\nprintln(name?.length ?: 0)",
            listOf("null", "0", "Error", "length"), 1),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_question)

        questionText = findViewById(R.id.question_text)
        radioGroup = findViewById(R.id.radio_group)
        optionA = findViewById(R.id.option_a)
        optionB = findViewById(R.id.option_b)
        optionC = findViewById(R.id.option_c)
        optionD = findViewById(R.id.option_d)
        nextBtn = findViewById(R.id.next_btn)
        scoreText = findViewById(R.id.score_text)

        loadQuestion()

        nextBtn.setOnClickListener {
            checkAnswer()
        }
    }

    private fun loadQuestion() {
        if (currentIndex < questions.size) {
            val q = questions[currentIndex]
            questionText.text = q.text
            optionA.text = "A) ${q.options[0]}"
            optionB.text = "B) ${q.options[1]}"
            optionC.text = "C) ${q.options[2]}"
            optionD.text = "D) ${q.options[3]}"
            radioGroup.clearCheck()
        } else {
            questionText.text = "Test tugadi! Sizning ball: $score / ${questions.size}"
            radioGroup.visibility = RadioGroup.GONE
            nextBtn.isEnabled = false
        }
    }

    private fun checkAnswer() {
        val selectedId = radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, "Iltimos, javobni tanlang!", Toast.LENGTH_SHORT).show()
            return
        }

        val answerIndex = when (selectedId) {
            R.id.option_a -> 0
            R.id.option_b -> 1
            R.id.option_c -> 2
            R.id.option_d -> 3
            else -> -1
        }

        if (answerIndex == questions[currentIndex].correctAnswer) {
            score++
            Toast.makeText(this, "To‘g‘ri ✅", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Xato ❌", Toast.LENGTH_SHORT).show()
        }

        scoreText.text = "Ball: $score"
        currentIndex++
        loadQuestion()
    }
}
