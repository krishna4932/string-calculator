package org.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class StringCalculatorTest {
    private val calculator = StringCalculator()

    @Test
    fun `handle empty string`() {
        assertEquals(0, calculator.add(""))
    }

    @Test
    fun `handle blank string`() {
        assertEquals(0, calculator.add("    "))
    }

    @Test
    fun `handle single number`() {
        assertEquals(1, calculator.add("1"))
    }

    @Test
    fun `handle comma separated numbers`() {
        assertEquals(9, calculator.add("1,8"))
    }

    @Test
    fun `handle numbers with new lines and commas`() {
        assertEquals(6, calculator.add("1\n2,3"))
    }

    @Test
    fun `handle the sum with custom single delimiter`() {
        assertEquals(3, calculator.add("//;\n1;2"))
    }
}