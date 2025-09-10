package com.example.kotlincoroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import com.example.kotlincoroutines.models.UserData
import com.example.kotlincoroutines.networking.ApiClient
import com.example.kotlincoroutines.networking.ApiService
import com.example.kotlincoroutines.vm.UserViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    private val TAG  = "MainActivity"
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

        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.getUsersLiveData().observe(this, Observer{
            Log.d(TAG, "onCreate: ${it.userList}")
            Log.d(TAG, "onCreate: ${it.postList}")
            showUsers(it.userList)
        })
    }
    private fun showUsers(userList: List<UserData>) {
        binding.tv.text = userList.toString()
    }
}