package com.example.cactusnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class signUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)
        supportActionBar?.title = getString(R.string.signUp_actionBar)
    }
}