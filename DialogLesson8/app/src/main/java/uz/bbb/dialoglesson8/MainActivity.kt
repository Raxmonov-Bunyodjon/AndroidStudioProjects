package uz.bbb.dialoglesson8

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import uz.bbb.dialoglesson8.adapters.SnackbarAdapter
import uz.bbb.dialoglesson8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var snackbarAdapter: SnackbarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = mutableListOf("Kotlin", "Java", "Python", "Flutter", "React")

        snackbarAdapter = SnackbarAdapter(list, object : SnackbarAdapter.OnItemClickListener {
            override fun onItemClick(str: String, position: Int,itemView: View) {
                // Elementni o'chirish
                list.removeAt(position)
                snackbarAdapter.notifyItemRemoved(position)
                snackbarAdapter.notifyItemRangeChanged(position, list.size)

                // Snackbar ko'rsatish
                Snackbar.make(binding.root, "$str o'chirildi", Snackbar.LENGTH_LONG)
                    .setAction("Undo") {
                        // Undo qilsa elementni qaytarish
                        list.add(position, str)
                        snackbarAdapter.notifyItemInserted(position)
                        snackbarAdapter.notifyItemRangeChanged(position, list.size)
                    }.show()
            }
        })

        binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rv.adapter = snackbarAdapter

        // Button bosilganda Snackbar
        binding.rv.setOnClickListener { view: View ->
            Snackbar.make(view, "Foydalanuvchini ortga qaytarish", Snackbar.LENGTH_LONG)
                .setAction("Undo") {
                    Toast.makeText(this@MainActivity, "Undo bosildi", Toast.LENGTH_SHORT).show()
                }.show()
        }
    }
}
