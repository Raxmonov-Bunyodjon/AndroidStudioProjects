package uz.bbb.androidbasiclesson10

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.bbb.androidbasiclesson10.models.FlagData


class FlagActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var list: ArrayList<FlagData>
    lateinit var image_view: ImageView
    lateinit var layout1: LinearLayout
    lateinit var layout2: LinearLayout
    lateinit var layout3: LinearLayout
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flag)
        image_view = findViewById(R.id.image_view)
        layout1 = findViewById(R.id.layout1)

        layout2 = findViewById(R.id.layout2)
        layout3 = findViewById(R.id.layout3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        loadFlags()
        setData(count)
    }

    private fun setData(c: Int) {
        image_view.setImageResource(list[c].image!!)
        val randomCountryList: List<String> = randomCountry(list[c].country!!.toUpperCase())
        for (i in 0 until 8) {
            var button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
            )
            button.text = randomCountryList[i]
            button.setOnClickListener(this)
            layout2.addView(button)
        }
        for (i in 8 until 16) {
            var button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
            )
            button.text = randomCountryList[i]
            button.setOnClickListener(this)
            layout3.addView(button)
        }
    }

    fun randomCountry(str: String): List<String> {
        val stringList = ArrayList<String>()
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val used = str.uppercase().toMutableList() // davlat nomidagi harflar

        // Avval davlat nomini qo‘shamiz
        for (ch in str.uppercase()) {
            stringList.add(ch.toString())
        }

        // Keyin qolgan joyni random harflar bilan to‘ldiramiz
        val random = alphabet.toMutableList()
        random.shuffle()

        for (c in random) {
            if (stringList.size < 16) {
                stringList.add(c.toString())
            } else break
        }

        // Oxirida butun ro‘yxatni shuffle qilamiz
        stringList.shuffle()
        return stringList
    }

    private fun loadFlags() {
        list = ArrayList()
        list.add(FlagData(R.drawable.uzbekistan, "Uzbekistan"))
        list.add(FlagData(R.drawable.amerika, "UnitedStates"))
        list.add(FlagData(R.drawable.angliya, "UnitedKingdom"))
        list.add(FlagData(R.drawable.kanada, "Canada"))
        list.add(FlagData(R.drawable.germaniya, "Germany"))
        list.add(FlagData(R.drawable.fransiya, "France"))
        list.add(FlagData(R.drawable.italiya, "Italy"))
        list.add(FlagData(R.drawable.ispaniya, "Spain"))
        list.add(FlagData(R.drawable.yaponiya, "Japan"))
        list.add(FlagData(R.drawable.janubiy_korea, "SouthKorea"))
        list.add(FlagData(R.drawable.xitoy, "China"))
        list.add(FlagData(R.drawable.hindiston, "India"))
        list.add(FlagData(R.drawable.brazilya, "Brazil"))
        list.add(FlagData(R.drawable.meksika, "Mexico"))
        list.add(FlagData(R.drawable.avstraliya, "Australia"))
        list.add(FlagData(R.drawable.turkiya, "Turkey"))
        list.add(FlagData(R.drawable.rassiya, "Russia"))
        list.add(FlagData(R.drawable.saudiya_arabiston, "SaudiArabia"))
        list.add(FlagData(R.drawable.msr, "Egypt"))
        list.add(FlagData(R.drawable.indaneziya, "Indonesia"))
    }


    override fun onClick(v: View?) {
        val clickedBtn = v as Button

        // Agar button layout2 yoki layout3 dan bosilsa
        if (clickedBtn.parent == layout2 || clickedBtn.parent == layout3) {
            // Bosilgan buttonni yashiramiz
            clickedBtn.visibility = View.INVISIBLE

            // Yangi button yasab layout1 ga qo‘shamiz
            val button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
            )
            button.text = clickedBtn.text.toString()

            // 🔑 Orqaga qaytarish uchun original buttonni saqlab qo‘yamiz
            button.tag = clickedBtn
            button.setOnClickListener { btn ->
                // Agar yuqoridagi button bosilsa, uni olib tashlaymiz
                layout1.removeView(btn)

                // Original pastdagi buttonni qaytaramiz
                val originalBtn = btn.tag as Button
                originalBtn.visibility = View.VISIBLE
            }

            layout1.addView(button)
        }

        // ✅ Endi tekshirish qismi
        val childCount: Int = layout1.childCount
        if (childCount == list[count].country?.length) {
            val stringBuilder = StringBuilder()
            for (i in 0 until childCount) {
                val btn: Button = layout1.getChildAt(i) as Button
                stringBuilder.append(btn.text.toString())
            }
            if (stringBuilder.toString() == list[count].country?.toUpperCase()) {
                count++
                layout1.removeAllViews()
                layout2.removeAllViews()
                layout3.removeAllViews()
                setData(count)
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }
        }
    }
}