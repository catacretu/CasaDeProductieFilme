package com.example.casadeproductiefilme.presenters

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.casadeproductiefilme.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var usernameIsEmpty = true
    private var passwordIsEmpty = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usernameField.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                usernameIsEmpty = binding.usernameField.text.toString() == ""
                binding.loginButton.isEnabled = !usernameIsEmpty && !passwordIsEmpty
            }
        })

        binding.passwordField.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                passwordIsEmpty = binding.passwordField.text.toString() == ""
                binding.loginButton.isEnabled = !usernameIsEmpty && !passwordIsEmpty
            }
        })

        binding.loginButton.setOnClickListener {
            val action = LoginFragmentDirections.goFromLoginFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }
}