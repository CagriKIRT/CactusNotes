package com.example.cactusnotes

class PasswordValidator(private val password: String) {
    fun isValid(): ValidationResult {
        return when {
            password.isEmpty() -> ValidationResult("Password is required.", false)
            password.length < 7 -> ValidationResult("Password is too short", false)
            password.length > 40 -> ValidationResult("Password is too long", false)
            password.length > 40 -> ValidationResult("Password is too long", false)
            isPasswordNamingValid() -> ValidationResult(
                "Password must contain one digit, one uppercase letter, one lowercase letter and one special character.",
                false
            )
            else -> ValidationResult(null, true)
        }
    }

    private fun isPasswordNamingValid() =
        password.containsDigit() && password.containsLowercase() && password.containsUppercase() && password.containsSpecialCharacter()

    private fun String.containsDigit() = any { it.isDigit() }
    private fun String.containsUppercase() = any { it.isUpperCase() }
    private fun String.containsLowercase() = any { it.isLowerCase() }
    private fun String.containsSpecialCharacter() = any { it.isLetterOrDigit().not() }

}