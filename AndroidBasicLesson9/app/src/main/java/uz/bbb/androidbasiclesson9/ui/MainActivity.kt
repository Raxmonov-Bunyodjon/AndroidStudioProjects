package uz.bbb.androidbasiclesson9.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import uz.bbb.androidbasiclesson9.R
import uz.bbb.androidbasiclesson9.models.User
import uz.bbb.androidbasiclesson9.utils.MySharedPreference

class MainActivity : AppCompatActivity() {

    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        MySharedPreference.init(this)
        val register: TextView = findViewById(R.id.register)
        val save_btn: Button = findViewById(R.id.save_btn)
        val edit1: EditText = findViewById(R.id.edit1)
        val edit2: EditText = findViewById(R.id.edit2)

        gson = Gson()

        register.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        save_btn.setOnClickListener {
            val username: String = edit1.text.toString()
            val password: String = edit2.text.toString()
            val userStr: String? = MySharedPreference.user
            if (userStr != "") {


                val user: User? = gson.fromJson<User>(userStr, User::class.java)
                if (user?.username == username && user.password == password) {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Username yoki parol xato", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}