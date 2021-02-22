package com.example.cactusnotes

fun String.containsDigit() = any { it.isDigit() }

fun String.containsUppercase() = any { it.isUpperCase() }

fun String.containsLowercase() = any { it.isLowerCase() }

fun String.containsSpecialCharacter() = any { it.isLetterOrDigit().not() }

fun String.isNameValid() = all { it.isDigit() || it.isLowerCase() || it == '_' }
