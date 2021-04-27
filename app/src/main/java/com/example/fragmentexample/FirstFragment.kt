package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.fragmentexample.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //use view binding
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        //passing data
        val name = "Robert"
        val age = 40
        val person = Person("Zoey", 20)  //pass object
        binding.nextButton.setOnClickListener { view ->
            view.findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(name,age, person))
        }

        //get the viewModel: set the owner to be the fragment
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        //get the viewModel: set the owner to be the main activity (shared viewmodel)
        //viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        binding.plusButton.setOnClickListener { viewModel.addOne() }

        // Inflate the layout for this fragment
        return binding.root
    }

}