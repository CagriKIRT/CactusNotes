package com.example.cactusnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cactusnotes.databinding.SignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=SignUpBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        supportActionBar?.title = getString(R.string.signUp_actionBar)
    }
}