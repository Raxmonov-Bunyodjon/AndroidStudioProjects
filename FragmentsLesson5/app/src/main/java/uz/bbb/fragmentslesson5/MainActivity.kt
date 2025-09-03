package uz.bbb.fragmentslesson5

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import uz.bbb.fragmentslesson5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // ✅ faqat bitta setContentView bo'ladi!

        ViewCompat.setOnApplyWindowInsetsListener(binding.container) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()


        binding.addBtn.setOnClickListener {
            val supportFragmentManager: FragmentManager = supportFragmentManager
            val beginTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.add(R.id.container, firstFragment,"first")
            beginTransaction.addToBackStack(firstFragment.toString())
            beginTransaction.commit()
        }


        binding.removeBtn.setOnClickListener {
            val supportFragmentManager: FragmentManager = supportFragmentManager
            val firstFragmentByTag: SecondFragment =
                supportFragmentManager.findFragmentByTag("second") as SecondFragment
            val beginTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.remove(firstFragmentByTag)
            supportFragmentManager.popBackStack()
            beginTransaction.commit()
        }

        binding.replaceBtn.setOnClickListener {
            val supportFragmentManager: FragmentManager = supportFragmentManager
            val beginTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(R.id.container, secondFragment,"second")
            beginTransaction.addToBackStack(secondFragment.toString())
            beginTransaction.commit()
        }

        binding.hideBtn.setOnClickListener {
            val supportFragmentManager: FragmentManager = supportFragmentManager
            val beginTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.hide(firstFragment)
            beginTransaction.commit()
        }

        binding.showBtn.setOnClickListener {
            val supportFragmentManager: FragmentManager = supportFragmentManager
            val beginTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.show(firstFragment)
            beginTransaction.commit()

        }


    }
}