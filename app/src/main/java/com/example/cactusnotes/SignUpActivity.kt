package com.example.cactusnotes

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

        supportActionBar?.title = getString(R.string.signUp_actionBarTitle)

        binding.signUpButton.setOnClickListener {
            if (isEmailValid() && isUsernameValid() && isPasswordValid()) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.successful),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.alreadyHaveAccountTextView.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.already_have_an_account),
                Toast.LENGTH_LONG
            ).show()
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
        val username = binding.signUpUsernameEditText.text.toString()
        val validationResult = UsernameValidator(username).validate()
        binding.signUpUsernameTextField.isErrorEnabled = !validationResult.isValid
        binding.signUpUsernameTextField.error = validationResult.errorMessage
        return validationResult.isValid
    }

    private fun isPasswordValid(): Boolean {
        val password = binding.signUpPasswordEditText.text.toString()
        val validationResult = PasswordValidator(password).validate()
        binding.signUpPasswordTextField.isErrorEnabled = !validationResult.isValid
        binding.signUpPasswordTextField.error = validationResult.errorMessage
        return validationResult.isValid
    }
}