package uz.bbb.playmarket

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.bbb.playmarket.adapters.InPlayMarketAdapter
import uz.bbb.playmarket.adapters.PlayMarketAdapter
import uz.bbb.playmarket.databinding.ActivityMainBinding
import uz.bbb.playmarket.models.GeneralData
import uz.bbb.playmarket.models.Program

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var playMarketAdapter: PlayMarketAdapter
    lateinit var generalList: ArrayList<GeneralData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        loadData()

        playMarketAdapter = PlayMarketAdapter(generalList)
        binding.rv.adapter = playMarketAdapter
    }

    private fun loadData() {
        generalList = ArrayList()
        val program1 = Program("https://store-images.s-microsoft.com/image/apps.30645.9007199266245907.cb06f1f9-9154-408e-b4ef-d19f2325893b.ac3b465e-4384-42a8-9142-901c0405e1bc","Facebook")
        val program2 = Program("https://store-images.s-microsoft.com/image/apps.43327.13510798887167234.cadff69d-8229-427b-a7da-21dbaf80bd81.79b8f512-1b22-45d6-9495-881485e3a87e","Instagram")
        val program3 = Program("https://cdn6.aptoide.com/imgs/c/7/6/c7644008f58970f3d495d2d68958652a_fgraphic.png","WhatsApp")
        val program4 = Program("https://www.nicepng.com/png/detail/244-2447348_olx-sellers-kidnapped-assaulted-and-scammed-by-namibians.png","OLX")
        generalList.add(GeneralData("Mashhurlar", listOf(program1,program2,program3,program4)))
        generalList.add(GeneralData("O'yinlar", listOf(program1,program2,program3,program4)))
        generalList.add(GeneralData("Tavsiya qilinganlar", listOf(program1,program2,program3,program4)))
        generalList.add(GeneralData("Kitoblar", listOf(program1,program2,program3,program4)))
    }
}