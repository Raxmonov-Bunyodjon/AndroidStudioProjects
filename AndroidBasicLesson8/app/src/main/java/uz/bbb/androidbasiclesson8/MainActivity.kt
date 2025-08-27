package uz.bbb.androidbasiclesson8

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {

    lateinit var tv1: TextView
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d(TAG, "onCreate: ")
        tv1 = findViewById(R.id.tv1)
        val button1: Button = findViewById(R.id.button1)

        button1.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345"))
            startActivity(intent)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val name: String? = data.getStringExtra("name")
            tv1.text = name
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onString: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }


}








//
//        val edit1: EditText = findViewById(R.id.edit1)
//        val edit2: EditText = findViewById(R.id.edit2)
//        val button1: Button = findViewById(R.id.button1)
////        val button2: Button = findViewById(R.id.button2)
////        val button3: Button = findViewById(R.id.button3)
//
//        button1.setOnClickListener {
//            val username:String = edit1.text.toString()
//            val password = edit2.text.toString()
//            val user = User(username, password)
//
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("user", user)
//            startActivity(intent)
//        }