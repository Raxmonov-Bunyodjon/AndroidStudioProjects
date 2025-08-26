package uz.bbb.androidbasiclesson7

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
        //alpha
//        val animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
        val button: Button = findViewById(R.id.button)
        val tv: TextView = findViewById(R.id.tv)
        val img: ImageView = findViewById(R.id.img)

//        val alphaAnimation = AlphaAnimation(0.0f,1.0f)
//        alphaAnimation.duration = 4000

        //scale
//        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.scale)
//            val animation = ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF, 0.5f,
//               Animation.RELATIVE_TO_SELF, 0.5f )
//            animation.duration = 5000

        //translate

//        val animation: Animation = AnimationUtils.loadAnimation(this,R.anim.translate)

//        val animation = TranslateAnimation(-100f, 300f, -100f, 300f)
//        animation.duration = 3000
        //rotate
//        val animation: Animation = AnimationUtils.loadAnimation(this,R.anim.rotate)

//        val animation = RotateAnimation(
//            0.0f, 360f,
//            Animation.RELATIVE_TO_SELF, 0.5f,
//            Animation.RELATIVE_TO_SELF, 0.5f
//        )
//        animation.duration = 2000

        val animation: Animation = AnimationUtils.loadAnimation(this,R.anim.combination3)
        animation.duration = 3000
        button.setOnClickListener {
        //    tv.startAnimation(animation)
            img.startAnimation(animation)
        }


    }
}

