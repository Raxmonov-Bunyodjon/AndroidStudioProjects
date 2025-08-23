package uz.bbb.androidbasiclesson4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import androidx.core.net.toUri


class MainActivity : AppCompatActivity() {

    val TAG = "RESPONSE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imagebutton_layout)
//        val edit1: EditText = findViewById(R.id.edit1)
//        val edit2: EditText = findViewById(R.id.edit2)
//
//        findViewById<Button>(R.id.button).setOnClickListener {

    //val toggle: ToggleButton = findViewById(R.id.toggle)

   val button: Button = findViewById(R.id.button)
   button.setOnClickListener {
       val text = "Assalomu alaykum"
       val duration = Toast.LENGTH_SHORT
       val toast = Toast.makeText(applicationContext, text, duration)

//       val tv = toast.view?.findViewById<TextView>(android.R.id.message) as TextView
//       tv.gravity = Gravity.CENTER
       toast.setGravity(Gravity.TOP, 0,0)
       toast.show()

      // Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
   }




    }
}


