package com.example.studenthub.ui.main.faculty

import androidx.fragment.app.Fragment
import com.example.studenthub.databinding.FragmentFacultyBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 🔹 FacultyFragment
 *   - Displays the list of faculties
 *   - Handles add, edit, and delete functions
 *   - Supports searching with SearchView
 */
@AndroidEntryPoint
class FacultyFragment : Fragment() {

    private var _binding: FragmentFacultyBinding? = null
    private val binding get() = _binding!!

    //private val viewModel: FacultyViewModel by viewModel()
    private lateinit var adapter: FacultyFragment


}

