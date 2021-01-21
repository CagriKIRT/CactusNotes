package com.example.cactusnotes

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun signUpButton(view: View) {

    }
    fun alreadyHaveAnAccountText(view: View) {
        startActivity(Intent(this, LogInActivity::class.java))
    }


}