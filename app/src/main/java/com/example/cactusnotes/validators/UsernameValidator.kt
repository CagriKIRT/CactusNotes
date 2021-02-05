package com.example.cactusnotes.validators

import com.example.cactusnotes.*

class UsernameValidator(private val username: String) {

    fun validate(): ValidationResult {
        return when {
            username.isEmpty() -> ValidationResult("Username is required.", false)
            username.isNameValid().not() -> ValidationResult(
                "Username can only include a-z, 0-9 and _ characters.",
                false
            )
            username.length < 2 -> ValidationResult("Username is too short", false)
            username.length > 20 -> ValidationResult("Username is too long", false)
            else -> ValidationResult(null, true)
        }
    }
}