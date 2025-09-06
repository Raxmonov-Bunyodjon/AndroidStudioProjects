package uz.bbb.viewpagertablayoutlesson9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import uz.bbb.viewpagertablayoutlesson9.adapters.RvAdapter
import uz.bbb.viewpagertablayoutlesson9.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private var param1: ArrayList<String>? = null
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getStringArrayList(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adapterni sozlash
        rvAdapter = RvAdapter(param1 ?: arrayListOf())

        // RecyclerView LayoutManager (3 ustun)
        binding.rv.layoutManager = GridLayoutManager(requireContext(), 3)

        // Adapterni ulash
        binding.rv.adapter = rvAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Memory leakdan saqlash
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(param1: List<String>) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_PARAM1, ArrayList(param1)) // 🔥 List → ArrayList
                }
            }
    }
}
