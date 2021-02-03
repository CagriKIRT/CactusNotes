package com.example.cactusnotes

class EmailValidationControl(private val email: String) {

    fun isValid(): ValidationResult {
        return when {
            email.isEmpty() -> ValidationResult("Email is required.", false)
            email.containsAtAndDot().not() -> ValidationResult("Email is invalid.", false)
            email.length < 5 -> ValidationResult("Email is invalid", false)
            email.length > 50 -> ValidationResult("Email is invalid", false)
            else -> ValidationResult(null, true)
        }
    }

    private fun String.containsAtAndDot() = contains("@") && contains(".")
}