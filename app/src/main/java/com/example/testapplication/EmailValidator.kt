package com.example.testapplication

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator : TextWatcher {
    internal var isValid = false
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(editableText: Editable?) {
        isValid = isValidEmail(editableText)
    }

    companion object {
        private val emailNull = null
        private val emailExample = "user@yandex.ru"
        private val emailArray = arrayOf("name@email.ru", "test@test.com", "user@user.co.uk")
        private val arrayNumber = arrayOf(1, 2, 3)

        //паттерн для сравнения
        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }

        fun checkEmail(email: String?): String? {
            return email
        }

        fun arrayOfEmail(array: Array<String>): Array<String> {
            return array
        }
    }
}