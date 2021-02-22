package com.example.cactusnotes.validators

import com.example.cactusnotes.ValidationResult

class EmailValidator : Validator {

    override fun validate(field: String): ValidationResult {
        return when {
            field.isEmpty() -> ValidationResult("Email is required.", false)
            field.containsAtAndDot().not() -> ValidationResult("Email is invalid.", false)
            field.length < 5 -> ValidationResult("Email is invalid", false)
            field.length > 50 -> ValidationResult("Email is invalid", false)
            else -> ValidationResult(null, true)
        }
    }

    private fun String.containsAtAndDot() = contains("@") && contains(".")
}