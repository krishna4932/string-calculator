package org.example

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isBlank()) return 0

        val numberList = parseNumbers(numbers)

        return numberList.sum()
    }

    private fun parseNumbers(numbers: String): List<Int> {
        return numbers
            .split(Regex("[\n,]"))
            .mapNotNull {
                it.toIntOrNull()
            }
    }
}