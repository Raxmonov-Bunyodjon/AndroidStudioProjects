package uz.bbb.androidbasiclesson7

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class GameActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var scoreText: TextView
    private lateinit var timeText: TextView

    private var firstCard: ImageView? = null
    private var secondCard: ImageView? = null
    private var firstImage = -1
    private var secondImage = -1
    private var score = 0
    private var moves = 0
    private var isTimerStarted = false

    private var timer: CountDownTimer? = null

    // 12 ta rasm (6 xil rasm, har biri 2 martadan)
    private val images = mutableListOf(
        R.drawable.rasm1, R.drawable.rasm1,
        R.drawable.rasm2, R.drawable.rasm2,
        R.drawable.rasm3, R.drawable.rasm3,
        R.drawable.rasm4, R.drawable.rasm4,
        R.drawable.rasm5, R.drawable.rasm5,
        R.drawable.rasm6, R.drawable.rasm6,
    )

    private val cards = mutableListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        scoreText = findViewById(R.id.score)
        timeText = findViewById(R.id.time)

        // shuffle images
        images.shuffle()

        val buttons = intArrayOf(
            R.id.card1, R.id.card2, R.id.card3, R.id.card4,
            R.id.card5, R.id.card6, R.id.card7, R.id.card8,
            R.id.card9, R.id.card10, R.id.card11, R.id.card12
        )

        for (i in buttons.indices) {
            val card = findViewById<ImageView>(buttons[i])
            card.tag = images[i] // har bir kartaga rasmni biriktiramiz
            card.setOnClickListener(this)
            cards.add(card)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        val card = view as ImageView

        // vaqtni faqat birinchi marta bosilganda boshlash
        if (!isTimerStarted) {
            startTimer()
            isTimerStarted = true
        }

        // karta ustiga bosilganda rasm chiqadi
        val image = card.tag as Int
        card.setImageResource(image)

        if (firstCard == null) {
            firstCard = card
            firstImage = image
        } else if (secondCard == null && card != firstCard) {
            secondCard = card
            secondImage = image
            moves++

            // 1 soniyadan keyin tekshir
            card.postDelayed({ checkMatch() }, 1000)
        }
    }

    private fun checkMatch() {
        if (firstImage == secondImage) {
            firstCard?.visibility = View.INVISIBLE
            secondCard?.visibility = View.INVISIBLE
            score++
            scoreText.text = "Score: $score"
        } else {
            firstCard?.setImageResource(R.drawable.yellow)
            secondCard?.setImageResource(R.drawable.yellow)
        }

        firstCard = null
        secondCard = null
    }

    private fun startTimer() {
        timer = object : CountDownTimer(3 * 60 * 1000, 1000) { // 3 minutlik vaqt
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                timeText.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                timeText.text = "Tugadi!"
                // bu yerda "o‘yin tugadi" chiqarsangiz ham bo‘ladi
            }
        }.start()
    }
}
