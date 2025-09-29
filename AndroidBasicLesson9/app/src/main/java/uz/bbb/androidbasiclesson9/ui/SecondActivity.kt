package uz.bbb.androidbasiclesson9.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import uz.bbb.androidbasiclesson9.R
import uz.bbb.androidbasiclesson9.models.User
import uz.bbb.androidbasiclesson9.utils.MySharedPreference

class SecondActivity : AppCompatActivity() {

    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        MySharedPreference.init(this)
        gson = Gson()

        val sign_up_btn: Button = findViewById(R.id.sing_up_btn)
        val edit1: EditText = findViewById(R.id.edit1)
        val edit2: EditText = findViewById(R.id.edit2)

        sign_up_btn.setOnClickListener {
            val username: String = edit1.text.toString()
            val password: String = edit2.text.toString()

            val user = User(username,password)
            val str: String? = gson.toJson(user)
            MySharedPreference.user = str
            finish()

        }
    }
}