package com.example.testapplication


import junit.framework.TestCase.*
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertNotEquals
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

    @Test
    fun emailValidator_EmailIsEqual_ReturnsTrue() {
        assertEquals("test@test.ru", EmailValidator.checkEmail("test@test.ru"))
    }

    @Test
    fun emailValidator_EmailIsNotEqual_ReturnsTrue() {
        assertNotEquals("test@test.ru", EmailValidator.checkEmail("user@user.com"))
    }

    @Test
    fun emailValidator_EmailIsNull_ReturnsTrue() {
        assertNull(EmailValidator.checkEmail(null))
    }

    @Test
    fun emailValidator_EmailIsNotNull_ReturnsTrue() {
        assertNotNull(EmailValidator.checkEmail("user@user.com"))
    }

    @Test
    fun emailValidator_ArrayEmailEquals_ReturnsTrue() {
        assertArrayEquals(
            arrayOf("test@test.ru", "user@user.com"), EmailValidator.arrayOfEmail(
                arrayOf("test@test.ru", "user@user.com")
            )
        )
    }

    @Test
    fun emailValidator_EmailSame_ReturnsTrue() {
        val a = "user@user.com"
        val b = EmailValidator.arrayOfEmail(
            arrayOf("test@test.ru", "user@user.com")
        )
        assertSame(a, b[1])
    }

    @Test
    fun emailValidator_ArrayEmailSame_ReturnsTrue() {
        val a = arrayOf("test@test.ru", "user@user.com")
        val b = EmailValidator.arrayOfEmail(a)
        assertSame(a, b)
    }
}