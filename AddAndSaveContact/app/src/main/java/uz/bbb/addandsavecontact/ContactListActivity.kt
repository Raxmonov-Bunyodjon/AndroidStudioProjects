package uz.bbb.addandsavecontact

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ContactListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listViewContacts)

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            lifecycleScope.launch {
                ContactDataStore.clearContacts(this@ContactListActivity)
            }
        }

        // DataStore dan o‘qish
        lifecycleScope.launch {
            ContactDataStore.getContacts(this@ContactListActivity).collectLatest { contacts ->
                Log.d("CONTACT_LIST", "Keldi: $contacts")
                val adapter = ArrayAdapter(
                    this@ContactListActivity,
                    R.layout.list_item_contact,   // custom layout
                    R.id.txtContact,              // xml ichidagi textview id
                    contacts.toList()
                )
                listView.adapter = adapter
            }
        }
    }
}

