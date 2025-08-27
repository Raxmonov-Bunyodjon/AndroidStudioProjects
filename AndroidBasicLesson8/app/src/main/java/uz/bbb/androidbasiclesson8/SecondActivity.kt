package uz.bbb.androidbasiclesson8

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat





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

        val button: Button = findViewById(R.id.button)
        val edit1: EditText = findViewById(R.id.edit1)

        button.setOnClickListener {
            val text: String = edit1.text.toString()
            val intent = Intent()
            setResult(RESULT_OK, intent)
            intent.putExtra("name", text)
            finish()

        }




//        val user: User = intent.getSerializableExtra("user") as User
//
//        val tv: TextView = findViewById(R.id.tv)
//
//        user?.let {
//            tv.text = "${it.username} ${it.password}"
//        }


    }
}