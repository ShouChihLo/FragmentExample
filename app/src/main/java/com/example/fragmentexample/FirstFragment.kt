package com.example.fragmentexample

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fragmentexample.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //use view binding to inflate layout
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

        //enable option menus
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }

}