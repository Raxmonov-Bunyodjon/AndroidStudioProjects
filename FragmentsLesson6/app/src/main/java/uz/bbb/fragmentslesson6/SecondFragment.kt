package uz.bbb.fragmentslesson6

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import uz.bbb.fragmentslesson6.databinding.FragmentSecondBinding
import javax.xml.datatype.DatatypeConstants.DURATION

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    lateinit var root: View
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = TransitionSet().apply {
            addTransition(Slide(Gravity.END))
            addTransition(Fade())
            duration = 500
        }

        exitTransition = TransitionSet().apply {
            addTransition(Slide(Gravity.START))
            addTransition(Fade())
            duration = 500
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        // Bu yerda replace emas, popBackStack ishlating
        binding.registerBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
//        : SecondFragment {
//            val bundle = Bundle()
//            bundle.putString("username", param1)
//
//            val secondFragment = SecondFragment()
//            secondFragment.arguments = bundle
//            return secondFragment
//        }

    }
}