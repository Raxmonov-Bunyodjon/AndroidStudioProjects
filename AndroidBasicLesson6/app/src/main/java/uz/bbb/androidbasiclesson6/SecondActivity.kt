package uz.bbb.androidbasiclesson6

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // bu endi senga loyihangdagi layoutni topib beradi

        val container = findViewById<ConstraintLayout>(R.id.container)


        val buttun = Button(this)
        buttun.text = "FIFA"
        container.addView(buttun)



        // agar programmatically yozmoqchi bo‘lsang:
        /*
        val linearLayout = LinearLayout(this)
        val linearLayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val textView = TextView(this)
        textView.text = "FIFA 2025"
        textView.setTextColor(getColor(R.color.black))
        linearLayout.addView(textView)

        linearLayout.setBackgroundColor(Color.RED)
        linearLayout.gravity = Gravity.CENTER
        linearLayout.layoutParams = linearLayoutParams

        setContentView(linearLayout, linearLayoutParams)
        */
    }
}
