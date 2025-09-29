package uz.bbb.android5expandablelistview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationBarView
import uz.bbb.android5expandablelistview.adapters.ExpandableAdapter
import uz.bbb.android5expandablelistview.adapters.SpinnerAdapter
import uz.bbb.android5expandablelistview.models.User

class SecondActivity : AppCompatActivity() {

    lateinit var spinnerAdapter: SpinnerAdapter

    lateinit var userList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner = findViewById<AppCompatSpinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)
        loadUsers()

        spinnerAdapter = SpinnerAdapter(userList)
        spinner.adapter = spinnerAdapter


        button.setOnClickListener {
            val selectedItemPosition: Int = spinner.selectedItemPosition
            Toast.makeText(this, userList[selectedItemPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadUsers() {
        userList = ArrayList()
        for(i: Int in 0..100){
            userList.add(User(R.drawable.ic_launcher_background, "Bunyod -> $i"))

        }
    }
}