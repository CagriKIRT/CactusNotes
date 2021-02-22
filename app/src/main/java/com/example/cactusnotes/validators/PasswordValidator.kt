package com.example.cactusnotes.validators

import com.example.cactusnotes.*

class PasswordValidator : Validator {

    override fun validate(field: String): ValidationResult {
        return when {
            field.isEmpty() -> ValidationResult("Password is required.", false)
            field.length < 7 -> ValidationResult("Password is too short", false)
            field.length > 40 -> ValidationResult("Password is too long", false)
            !field.isNamingValid() -> ValidationResult(
                "Password must contain one digit, one uppercase letter, one lowercase letter and one special character.",
                false
            )
            else -> ValidationResult(null, true)
        }
    }

    private fun String.isNamingValid() = containsDigit()
            && containsLowercase()
            && containsUppercase()
            && containsSpecialCharacter()
}