package com.example.cactusnotes.validators

import com.example.cactusnotes.ValidationResult

interface Validator {
    fun validate(field: String): ValidationResult
}