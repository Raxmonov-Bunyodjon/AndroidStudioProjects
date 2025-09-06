package uz.bbb.viewpagertablayoutlesson9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import uz.bbb.viewpagertablayoutlesson9.databinding.FragmentUserBinding
import uz.bbb.viewpagertablayoutlesson9.models.User

private const val ARG_PARAM1 = "param1"

class UserFragment : Fragment() {

    private var param1: User? = null
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1) // ✅ Serializable ishlatyapmiz
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)

        binding.apply {
            nameTv.text = param1?.name
            Picasso.get().load(param1?.img).into(imageView) // ✅
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: User) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1) // ✅ Serializable ishlatyapmiz
                }
            }
    }
}