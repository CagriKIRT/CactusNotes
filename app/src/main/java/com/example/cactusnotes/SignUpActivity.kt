package com.example.cactusnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cactusnotes.databinding.SignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = getString(R.string.signUp_actionBar)

        binding.signUpButton.setOnClickListener {
            if (isEmailValid() && isUsernameValid() && isPasswordValid()) {
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isEmailValid(): Boolean {
        val email = EmailValidator(binding.signUpEmailEditText.text.toString())
        return if (!email.isValid().result) {
            binding.signUpEmailTextField.isErrorEnabled = true
            binding.signUpEmailTextField.error = email.isValid().errorMessage
            false
        } else {
            binding.signUpEmailTextField.isErrorEnabled = false
            true
        }
    }

    private fun isUsernameValid(): Boolean {
        val username = UsernameValidator(binding.signUpUsernameEditText.text.toString())
        return if (!username.isValid().result) {
            binding.signUpUsernameTextField.isErrorEnabled = true
            binding.signUpUsernameTextField.error = username.isValid().errorMessage
            false
        } else {
            binding.signUpUsernameTextField.isErrorEnabled = false
            true
        }
    }

    private fun isPasswordValid(): Boolean {
        val password = PasswordValidator(binding.signUpPasswordEditText.text.toString())
        return if (!password.isValid().result) {
            binding.signUpPasswordTextField.isErrorEnabled = true
            binding.signUpPasswordTextField.error = password.isValid().errorMessage
            false
        } else {
            binding.signUpPasswordTextField.isErrorEnabled = false
            true
        }
    }
}