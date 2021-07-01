package com.example.dogs.dogsList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dogs.MainActivity
import com.example.dogs.R
import com.example.dogs.databinding.FragmentDogsBinding

class DogsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentDogsBinding.inflate(inflater)
        val viewModel= ViewModelProvider(this).get(DogsViewModel::class.java)

        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        val adapter= DogsAdapter(DogListener{
            viewModel.onDogClicked(it)
        })

        binding.listDogs.adapter=adapter

        viewModel.list.observe(viewLifecycleOwner, Observer {
            it.let{
                adapter.submitList(it)
            }
        })

        viewModel.imgString.observe(viewLifecycleOwner, Observer {
            it?.let{
                this.findNavController().navigate(DogsFragmentDirections.actionDogsFragmentToDetailFragment(it))
                viewModel.onNavigate()
            }
        })

        viewModel.datosOk.observe(viewLifecycleOwner, Observer {
            if(it){
                Toast.makeText(context,"ingrese una raza", Toast.LENGTH_SHORT).show()
                viewModel.faltanDatos()
            }
        })

        return binding.root
    }
}