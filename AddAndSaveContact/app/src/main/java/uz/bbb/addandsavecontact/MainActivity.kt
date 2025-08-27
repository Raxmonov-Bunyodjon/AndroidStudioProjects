package uz.bbb.addandsavecontact

import android.os.Bundle
import android.widget.Button
import android.content.Intent
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

        val btnView = findViewById<Button>(R.id.contact_list_btn)
        val btnAdd = findViewById<Button>(R.id.contact_add_btn)

        btnView.setOnClickListener {
            startActivity(Intent(this, ContactListActivity::class.java))
        }

        btnAdd.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
    }
}







