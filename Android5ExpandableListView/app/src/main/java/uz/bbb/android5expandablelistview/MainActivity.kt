package uz.bbb.android5expandablelistview

import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DialogTitle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.bbb.android5expandablelistview.adapters.ExpandableAdapter

class MainActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, List<String>>
    lateinit var titleList: ArrayList<String>
    lateinit var expandableAdapter: ExpandableAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadData()

        val expandable_list_view = findViewById<ExpandableListView>(R.id.expandable_list_view)
        expandableAdapter = ExpandableAdapter(titleList, map)
        expandable_list_view.setAdapter(expandableAdapter)


//        expandable_list_view.setOnGroupClickListener {parent, v, groupPosition, id ->
//            Toast.makeText(this, titleList[groupPosition], Toast.LENGTH_SHORT).show()
//            true
//        }

        expandable_list_view.setOnGroupCollapseListener {
            Toast.makeText(this, "Collapse -> ${titleList[it]}", Toast.LENGTH_SHORT).show()
        }

        expandable_list_view.setOnGroupExpandListener {
            Toast.makeText(this, "Expand -> ${titleList[it]}", Toast.LENGTH_SHORT).show()
        }

        expandable_list_view.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(this, map[titleList[groupPosition]]?.get(childPosition), Toast.LENGTH_SHORT).show()
            true
        }
        expandable_list_view.setOnGroupExpandListener { expandedGroupPosition ->
            for (i in titleList.indices) {
                if (i != expandedGroupPosition) {
                    expandable_list_view.collapseGroup(i)
                }
            }
            Toast.makeText(this, "Expand -> ${titleList[expandedGroupPosition]}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadData() {
        map = HashMap()

        val spainList = arrayListOf("Real Madrid", "Barselona", "Atletico")

        map["Spain"] = spainList

        val englangList = arrayListOf("Manchester United", "Arsenal", "Chelsea", "Manchester Siti")
        map["England"] = englangList

        val italyList = arrayListOf("Yuventus", "Napoli", "Milan")
        map["Italy"] = italyList

        titleList = ArrayList()
        titleList.add("Spain")
        titleList.add("England")
        titleList.add("Italy")
    }
}