package com.example.mvvminandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvminandroid.database.AppDatabase
import com.example.mvvminandroid.databinding.ActivityMainBinding
import com.example.mvvminandroid.networking.ApiClient
import com.example.mvvminandroid.utils.NetworkHelper
import com.example.mvvminandroid.vm.Resource
import com.example.mvvminandroid.vm.UserViewModel
import com.example.mvvminandroid.vm.UserViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//View
class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private val TAG = "MainActivity"
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
        viewModel = ViewModelProvider(this, UserViewModelFactory(AppDatabase.getInstance(this),
            ApiClient.apiService, NetworkHelper(this)))[UserViewModel::class.java]

        launch {
            viewModel.getStateFlow()
                .collect {
                    when(it){
                        is Resource.Error<*> -> {
                            Toast.makeText(this@MainActivity, it.e.message, Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Loading<*> -> {

                        }
                        is Resource.Success<*> -> {
                            Log.d(TAG, "onCreate: ${it.data}")
                        }
                    }
                }
        }

        // MVC
        // MVP
        // MVVM -> Model    View    ViewModel

        viewModel.getStateFlow()
        //M
        //V
        //ViewModel

    }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}