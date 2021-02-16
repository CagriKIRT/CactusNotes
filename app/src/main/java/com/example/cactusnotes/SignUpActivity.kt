package com.example.cactusnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cactusnotes.databinding.SignUpBinding
import com.example.cactusnotes.validators.EmailValidator
import com.example.cactusnotes.validators.PasswordValidator
import com.example.cactusnotes.validators.UsernameValidator
import com.example.cactusnotes.validators.Validator
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

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

    private fun TextInputLayout.isFieldValid(validator: Validator): Boolean {
        val editText = editText
        val field = editText!!.text.toString()
        val validationResult = validator.validate(field)
        isErrorEnabled = !validationResult.isValid
        error = validationResult.errorMessage
        return validationResult.isValid
    }

    private fun isEmailValid() = binding.signUpEmailTextField.isFieldValid(EmailValidator())

    private fun isUsernameValid() =
        binding.signUpUsernameTextField.isFieldValid(UsernameValidator())

    private fun isPasswordValid() =
        binding.signUpPasswordTextField.isFieldValid(PasswordValidator())
}