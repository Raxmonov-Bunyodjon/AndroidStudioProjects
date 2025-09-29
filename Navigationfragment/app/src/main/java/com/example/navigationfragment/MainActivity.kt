package com.example.navigationfragment

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.navigationfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener{
            val itemId: Int = it.itemId
            when (itemId) {
                R.id.first -> {
                    binding.container.setBackgroundColor(Color.BLUE)
                }
                R.id.second -> {
                    binding.container.setBackgroundColor(Color.CYAN)
                }
                R.id.third -> {
                    binding.container.setBackgroundColor(Color.RED)
                }

                R.id.four -> {
                    binding.container.setBackgroundColor(Color.YELLOW)
                }
                R.id.five -> {
                    binding.container.setBackgroundColor(Color.GREEN)
                }
            }
            true
        }
    }
}