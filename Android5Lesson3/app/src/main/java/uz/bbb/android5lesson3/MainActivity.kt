package uz.bbb.android5lesson3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uz.bbb.android5lesson3.adapters.ContactAdapter
import uz.bbb.android5lesson3.databinding.ActivityMainBinding
import uz.bbb.android5lesson3.models.Contact



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var contactAdapter: ContactAdapter
    lateinit var contactList: ArrayList<Contact>
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loodContacts()

        contactAdapter = ContactAdapter(contactList,object:ContactAdapter.OnMyItemClickListener {
            override fun onMyItemClick(contact: Contact,position: Int) {

//                contact.name = "FIFA"
//                contact.number = "779788"
//                contactAdapter.notifyItemChanged(position)

                contactList.remove(contact)
                contactAdapter.notifyItemRemoved(position)
                contactAdapter.notifyItemRangeChanged(position, contactList.size)


            }



//            override fun onMyItemLongClick(contact: Contact) {
//                Toast.makeText(this@MainActivity, "$contact", Toast.LENGTH_SHORT).show()
//            }
        })


        binding.rv.adapter = contactAdapter


        binding.addBtn.setOnClickListener {
            val s1:String = binding.contactName.text.toString()
            val s2:String = binding.contactNumber.text.toString()
            val contact = Contact(s1,s2)
            contactList.add(contact)
            contactAdapter.notifyItemChanged(contactList.size)

        }

    }

    private fun loodContacts() {
        contactList = ArrayList()
    }
}