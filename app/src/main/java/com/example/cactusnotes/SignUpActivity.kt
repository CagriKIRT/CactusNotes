package com.example.cactusnotes

import android.opengl.ETC1.isValid
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cactusnotes.databinding.SignUpBinding
import com.example.cactusnotes.validators.EmailValidator
import com.example.cactusnotes.validators.PasswordValidator
import com.example.cactusnotes.validators.UsernameValidator

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
        val email = binding.signUpEmailEditText.text.toString()
        val validationResult = EmailValidator(email).validate()
        binding.signUpEmailTextField.isErrorEnabled = !validationResult.isValid
        binding.signUpEmailTextField.error = validationResult.errorMessage
        return validationResult.isValid
    }

    private fun isUsernameValid(): Boolean {
        val username = UsernameValidator(binding.signUpUsernameEditText.text.toString())
        return if (!username.isValid().isValid) {
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
        return if (!password.isValid().isValid) {
            binding.signUpPasswordTextField.isErrorEnabled = true
            binding.signUpPasswordTextField.error = password.isValid().errorMessage
            false
        } else {
            binding.signUpPasswordTextField.isErrorEnabled = false
            true
        }
    }
}