package com.example.ecommerceappdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.ecommerceappdemo.R
import com.example.ecommerceappdemo.databinding.FragmentRegisterBinding
import com.example.ecommerceappdemo.models.UserRegisterModel


class RegisterFragment : Fragment() {


    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvLoginRF.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)

        }
        binding.btnRegister.setOnClickListener {
            userRegistration()
        }
    }

    private fun userRegistration() {
        val name: String = binding.etUserName.text.toString().trim()
        val email: String = binding.etUserEmail.text.toString().trim()
        val password: String = binding.etEmailPass.text.toString().trim()
        val confirmPass: String = binding.etEmailConfirmPass.text.toString().trim()

        //check name is empty or not
        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Enter your name pls !", Toast.LENGTH_LONG).show()
            return
        }
        //check email is empty or not
        if (email.isEmpty()) {
            Toast.makeText(requireContext(), "Enter your email pls !", Toast.LENGTH_LONG).show()
            return
        }
        //check valid email  or not
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(requireContext(), "Please enter a valid  Email", Toast.LENGTH_LONG)
                .show();
            return
        }
        //check password is empty or not
        if (password.isEmpty()) {
            Toast.makeText(requireContext(), "Enter your password pls !", Toast.LENGTH_LONG).show()
            return
        }
        //check password length less then 6  or not
        if (password.length < 6) {
            Toast.makeText(
                requireContext(),
                "Password length should be at least 6",
                Toast.LENGTH_LONG
            ).show();
            return
        }
        //check confirm password  is empty or not
        if (confirmPass.isEmpty()) {
            Toast.makeText(requireContext(), "Re-entered your password", Toast.LENGTH_LONG).show()
            return
        }
        //check password match  or not
        if (password != confirmPass) {
            Toast.makeText(requireContext(), "Password not matched", Toast.LENGTH_LONG).show()
            return
        }

        val user = UserRegisterModel(name, email, password, confirmPass)
        Navigation.findNavController(requireView()).navigate(R.id.loginFragment)

        Toast.makeText(requireContext(), "Successfully registered", Toast.LENGTH_LONG).show()


    }
}