package com.example.testapplication


import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("test@test.ru"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("test@test"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("user@test..ru"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@gmail.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_NoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@"))
    }

    @Test
    fun emailValidator_NoSplitNameAndDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("nameyandex.ru"))
    }

    @Test
    fun emailValidator_NoNameAndDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@"))
    }

    @Test
    fun emailValidator_IncorrectEmailSubDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email.co."))
    }

    @Test
    fun emailValidator_IncorrectSplitBetweenNameAndDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name.email.ru"))
    }

    @Test
    fun emailValidator_IncorrectTypeOnlyNumbers_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("1111.111"))
    }
}