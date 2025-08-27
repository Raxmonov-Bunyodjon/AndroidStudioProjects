package uz.bbb.addandsavecontact

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtName = findViewById<EditText>(R.id.ediName)
        val edtPhone = findViewById<EditText>(R.id.edtPhone)
        val btnSave = findViewById<Button>(R.id.btn_Save)

        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            val phone = edtPhone.text.toString()

            // DataStore ga saqlash
            lifecycleScope.launch {
                ContactDataStore.saveContact(this@AddContactActivity, name, phone)
                startActivity(Intent(this@AddContactActivity, ContactListActivity::class.java))
                finish()
            }
        }
    }
}
