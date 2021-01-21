package com.example.cactusnotes

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.databinding.ActivityLogInBinding


class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Log in"
    }

    fun createAnAccount(view: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun LogInButton(view: View) {
        when {
            isMailEmpty() && isPasswordEmpty() -> {
                mailErrorMessage()
                passwordErrorMessage()
            }
            isMailEmpty() -> mailErrorMessage()
            isPasswordEmpty() -> passwordErrorMessage()
            else -> {
                startActivity(Intent(this, NoteListActivity::class.java))
                finish()
            }
        }
    }

    private fun isMailEmpty() = binding.loginMailOrUsernameEdittext.text.isNullOrEmpty()

    private fun isPasswordEmpty() = binding.passwordEdittext.text.isNullOrEmpty()

    private fun mailErrorMessage() {
        binding.NameOrMailTextInputLayout.error = "Email or username is required."
    }

    private fun passwordErrorMessage() {
        binding.PasswordTextInputLayout.error = "Password is required."
    }
}