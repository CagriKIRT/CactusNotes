package com.example.cactusnotes.validators

import com.example.cactusnotes.*

class PasswordValidator(private val password: String) {
    fun validate(): ValidationResult {
        return when {
            password.isEmpty() -> ValidationResult("Password is required.", false)
            password.length < 7 -> ValidationResult("Password is too short", false)
            password.length > 40 -> ValidationResult("Password is too long", false)
            !isPasswordNamingValid() -> ValidationResult(
                "Password must contain one digit, one uppercase letter, one lowercase letter and one special character.",
                false
            )
            else -> ValidationResult(null, true)
        }
    }

    private fun isPasswordNamingValid() =
        password.containsDigit() && password.containsLowercase() && password.containsUppercase() && password.containsSpecialCharacter()


}