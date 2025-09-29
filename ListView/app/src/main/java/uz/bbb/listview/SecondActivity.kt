package uz.bbb.listview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.intIntMapOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso
import uz.bbb.listview.models.ImageData

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text_view = findViewById<TextView>(R.id.text_view)

        val intent: Intent? = intent
        val t: ImageData? = intent?.getSerializableExtra("image") as ImageData

        val image = findViewById<ImageView>(R.id.image)


        Picasso.get().load(t?.imgUrl).into(image)
        text_view.text = t?.text

    }
}