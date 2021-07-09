package com.example.shibesample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.example.shibesample.R
import com.example.shibesample.databinding.MainFragmentBinding
import com.example.shibesample.ui.main.adapter.ShibeAdapter
import com.example.shibesample.utils.Resource

class MainFragment : Fragment() {

    // ViewModelProvider(this).get(MainViewModel::class.java)
    private val viewModel: MainViewModel by viewModels()
    // ViewModelProvider(requireActivity).get(MainViewModel::class.java)
    // private val viewModel : MainViewModel by activityViewModels()
    // ViewModelProvider(NavController).get(MainViewModel::class.java)
    // private val viewModel : MainViewModel by navGraphViewModels()

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel.shibes.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        progressBar.isVisible = true
                    }
                    is Resource.Error -> {
                        progressBar.isVisible = false
                        Toast.makeText(requireContext(), it.errorMsg, Toast.LENGTH_LONG).show()
                    }
                    is Resource.Success -> {
                        progressBar.isVisible = false
                        shibeRv.adapter = ShibeAdapter(it.data.urls)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}