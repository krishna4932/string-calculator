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
    fun `handle the sum with custom single delimiter with single length`() {
        assertEquals(3, calculator.add("//;\n1;2"))
    }

    @Test
    fun `should throw exception if negative numbers exist`() {
        val exception = org.junit.jupiter.api.assertThrows<Exception> {
            calculator.add("//;\n1;-2")
        }
        assertEquals("negatives not allowed: -2", exception.message)

        val multiNegativeException = org.junit.jupiter.api.assertThrows<Exception> {
            calculator.add("//[*][%]\n-1*2%3*-4")
        }
        assertEquals("negatives not allowed: -1,-4", multiNegativeException.message)
    }

    @Test
    fun `handle the sum with custom single delimiter with any length`() {
        assertEquals(22, calculator.add("//[***]\n1***21"))
    }

    @Test
    fun `handle the sum with multiple custom delimiters`() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"))
    }

    @Test
    fun `handle the sum with multiple custom delimiters with any length`() {
        assertEquals(33, calculator.add("//[*][%%]\n1*2%%30"))
    }

    @Test
    fun `handle ignoring numbers greater than 1000`() {
        assertEquals(3, calculator.add("1,2,1001"))
        assertEquals(3, calculator.add("//[*][%]\n1*2%1001"))
    }
}