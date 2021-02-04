package com.example.cactusnotes

class UsernameValidationControl(private val username: String) {

    fun isValid(): ValidationResult {
        return when {
            username.isEmpty() -> ValidationResult("Username is required.", false)
            !isNameValid() -> ValidationResult("Username can only include a-z, 0-9 and _ characters.", false)
            username.length < 2 -> ValidationResult("Username is too short", false)
            username.length > 20 -> ValidationResult("Username is too long", false)
            else -> ValidationResult(null, true)
        }
    }

    private fun isNameValid(): Boolean {
        var result = true
        for (i in 0..username.lastIndex) {
            if (username[i].toInt() !in 0..9 || username[i] !in 'a'..'z' || username[i] != '_') {
                result = false
            }
        }
        return result
    }
}