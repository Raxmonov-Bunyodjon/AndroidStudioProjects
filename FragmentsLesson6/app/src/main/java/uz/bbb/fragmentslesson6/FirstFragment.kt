package uz.bbb.fragmentslesson6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.bbb.fragmentslesson6.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    // Binding object (private, nullable)
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding.registerTv.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.button.setOnClickListener {
            val homeFragment = HomeFragment()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, homeFragment)
                ?.addToBackStack(homeFragment.toString())
                ?.commit()
        }

        return binding.root
    }
}