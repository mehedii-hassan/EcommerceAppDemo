package com.example.ecommerceappdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.ecommerceappdemo.R
import com.example.ecommerceappdemo.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {


private lateinit var binding:  FragmentRegisterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvLoginRF.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.loginFragment)

        }
    }
}