package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.fragmentexample.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //use view binding
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.previousButton.setOnClickListener { view ->
            view.findNavController()
                .navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
        }

        //retrieve the passed arguments
        val args = SecondFragmentArgs.fromBundle(requireArguments())
        //Toast.makeText(context, "Name: ${args.name} Age: ${args.age}", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Name: ${args.person.name} Age: ${args.person.age}", Toast.LENGTH_LONG).show()

        //get the viewModel: set the owner to be the fragment
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        //get the viewModel: set the owner to be the main activity (shared viewmodel)
        //viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        binding.minusButton.setOnClickListener { viewModel.minusOne() }

        // Inflate the layout for this fragment
        return binding.root

    }
}