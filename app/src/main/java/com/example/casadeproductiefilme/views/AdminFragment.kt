package com.example.casadeproductiefilme.views

import android.R
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.casadeproductiefilme.data.local.entity.UserEntity
import com.example.casadeproductiefilme.databinding.FragmentAdminBinding
import com.example.casadeproductiefilme.presenters.user.UserPresenter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AdminFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentAdminBinding? = null
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
        _binding = FragmentAdminBinding.inflate(inflater, container, false)
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
                binding.registerButton.isEnabled = !usernameIsEmpty && !passwordIsEmpty
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
                binding.registerButton.isEnabled = !usernameIsEmpty && !passwordIsEmpty
            }
        })

        val usersList = presenter.getAllUsers()

        val dataAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            usersList
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.userList.adapter = adapter
        }

        binding.registerButton.setOnClickListener {
            val username = binding.usernameField.text.toString()
            val password = binding.passwordField.text.toString()
            if (presenter.checkCredentials(username, password) == null) { //if user exists
                presenter.saveUser(UserEntity(username = username, password = password))
                Toast.makeText(context, "User add successfully!", Toast.LENGTH_SHORT).show()
                dataAdapter.add(username)
                dataAdapter.notifyDataSetChanged()

            } else
                Toast.makeText(
                    context,
                    "User exists! Please use another credentials!",
                    Toast.LENGTH_SHORT
                ).show()
        }

        binding.userList.onItemSelectedListener = this

        binding.deleteButton.setOnClickListener {
            val user = binding.userList.selectedItem.toString()
            presenter.deleteUser(user)
            Toast.makeText(context, "User deleted successfully!", Toast.LENGTH_SHORT).show()
            dataAdapter.remove(user)
            dataAdapter.notifyDataSetChanged()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        binding.deleteButton.isEnabled = true
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}