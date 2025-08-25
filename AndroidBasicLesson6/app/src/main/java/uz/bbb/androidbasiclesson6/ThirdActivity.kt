package uz.bbb.androidbasiclesson6

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

class ThirdActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edit: EditText
    private var numberText: String = ""   // ekranda yozilayotgan raqam
    private var number1: Double? = null   // birinchi son
    private var operationType: String? = null // amal turi (+, -, *, /, %)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // EditText
        edit = findViewById(R.id.edit)

        // Tugmalar
        val buttons = intArrayOf(
            R.id.zero_btn, R.id.one_btn, R.id.two_btn, R.id.three_btn,
            R.id.four_btn, R.id.five_btn, R.id.six_btn, R.id.seven_btn,
            R.id.eight_btn, R.id.nine_btn, R.id.addition_btn, R.id.subtraction_btn,
            R.id.multiplication_btn, R.id.division_btn, R.id.percent_btn,
            R.id.decimal_point_btn, R.id.plus_minus_btn,
            R.id.equals_btn, R.id.all_clear_btn
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.zero_btn -> appendNumber("0")
            R.id.one_btn -> appendNumber("1")
            R.id.two_btn -> appendNumber("2")
            R.id.three_btn -> appendNumber("3")
            R.id.four_btn -> appendNumber("4")
            R.id.five_btn -> appendNumber("5")
            R.id.six_btn -> appendNumber("6")
            R.id.seven_btn -> appendNumber("7")
            R.id.eight_btn -> appendNumber("8")
            R.id.nine_btn -> appendNumber("9")
            R.id.decimal_point_btn -> appendDecimal()

            R.id.addition_btn -> setOperation("add")
            R.id.subtraction_btn -> setOperation("subtract")
            R.id.multiplication_btn -> setOperation("multiply")
            R.id.division_btn -> setOperation("divide")
            R.id.percent_btn -> setOperation("percent")

            R.id.plus_minus_btn -> toggleSign()
            R.id.all_clear_btn -> clearAll()
            R.id.equals_btn -> calculateResult()
        }
    }

    private fun appendNumber(num: String) {
        numberText += num
        edit.setText(numberText)
    }

    private fun appendDecimal() {
        if (!numberText.contains(".")) {
            if (numberText.isEmpty()) {
                numberText = "0."
            } else {
                numberText += "."
            }
            edit.setText(numberText)
        }
    }

    private fun setOperation(op: String) {
        number1 = numberText.toDoubleOrNull()
        operationType = op
        numberText = ""
        edit.setText("")
    }

    private fun toggleSign() {
        if (numberText.isNotEmpty()) {
            if (numberText.startsWith("-")) {
                numberText = numberText.substring(1)
            } else {
                numberText = "-$numberText"
            }
            edit.setText(numberText)
        }
    }

    private fun clearAll() {
        numberText = ""
        number1 = null
        operationType = null
        edit.setText("")
    }

    private fun calculateResult() {
        val number2 = numberText.toDoubleOrNull()
        if (number1 != null && number2 != null && operationType != null) {
            val rawResult = when (operationType) {
                "add" -> number1!! + number2
                "subtract" -> number1!! - number2
                "multiply" -> number1!! * number2
                "divide" -> if (number2 != 0.0) number1!! / number2 else Double.NaN
                "percent" -> number1!! * number2 / 100
                else -> 0.0
            }

            val rounded = BigDecimal(rawResult).setScale(10, RoundingMode.HALF_UP).stripTrailingZeros()
            val resultStr = rounded.toPlainString()

            edit.setText(resultStr)
            numberText = resultStr
            number1 = null
            operationType = null
        }
    }
}