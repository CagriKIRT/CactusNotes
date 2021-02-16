package com.example.cactusnotes.validators

import com.example.cactusnotes.*

class UsernameValidator : Validator {

    override fun validate(field: String): ValidationResult {
        return when {
            field.isEmpty() -> ValidationResult("Username is required.", false)
            field.isNameValid().not() -> ValidationResult(
                "Username can only include a-z, 0-9 and _ characters.",
                false
            )
            field.length < 2 -> ValidationResult("Username is too short", false)
            field.length > 20 -> ValidationResult("Username is too long", false)
            else -> ValidationResult(null, true)
        }
    }
}