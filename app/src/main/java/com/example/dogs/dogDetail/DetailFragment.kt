package com.example.dogs.dogDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dogs.R
import com.example.dogs.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding= FragmentDetailBinding.inflate(inflater)

        val arg=DetailFragmentArgs.fromBundle(arguments!!).urlString
        val viewModelFactory= DetailViewModelFactory(arg)
        val viewModel= ViewModelProvider(this,viewModelFactory).get(DetailViewModel::class.java)

        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        return binding.root
    }
}