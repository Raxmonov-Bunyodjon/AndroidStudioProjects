package uz.bbb.androidbasiclesson6

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        tv.setOnClickListener {
            Toast.makeText(this, "Text clicked", Toast.LENGTH_SHORT).show()
        }
        registerForContextMenu(tv) // kontekst menyu uchun

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Android Basic Lesson 6"
        toolbar.setTitleTextColor(Color.WHITE)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)

        // Menyu ikonkalari rangini oq qilish
        for (i in 0 until (menu?.size() ?: 0)) {
            val drawable = menu?.getItem(i)?.icon
            drawable?.setTint(Color.WHITE)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                Toast.makeText(this, "Save item clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.edit -> {
                Toast.makeText(this, "Edit item clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.delete -> {
                Toast.makeText(this, "Delete item clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        when (itemId) {
            R.id.add -> {
                Toast.makeText(this, "Add item click", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.remove -> {
                Toast.makeText(this, "Remove item click", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
