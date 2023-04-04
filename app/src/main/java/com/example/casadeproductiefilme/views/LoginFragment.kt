package com.example.casadeproductiefilme.views

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.casadeproductiefilme.databinding.FragmentLoginBinding
import com.example.casadeproductiefilme.presenters.user.UserPresenter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var usernameIsEmpty = true
    private var passwordIsEmpty = true

    @Inject
    lateinit var presenter: UserPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

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
            val username = binding.usernameField.text.toString()
            val password = binding.passwordField.text.toString()
            val user = presenter.checkCredentials(username, password)
            when (user) {
                "admin" -> goToAdminScreen()
                "manag" -> goToHomeScreen()
                "user" -> goToHomeScreen()
                else -> Toast.makeText(context, "Invalid credentials!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToAdminScreen() {
        val action = LoginFragmentDirections.goFromLoginFragmentToAdminFragment()
        findNavController().navigate(action)
    }

    private fun goToHomeScreen() {
        val action = LoginFragmentDirections.goFromLoginFragmentToHomeFragment()
        findNavController().navigate(action)
    }
}