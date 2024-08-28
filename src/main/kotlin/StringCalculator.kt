package org.example

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isBlank()) return 0

        val (delimiter, actualNumbers) = parseDelimiter(numbers)
        val numberList = parseNumbers(actualNumbers, delimiter)

        return numberList.sum()
    }

    private fun parseNumbers(numbers: String, delimiter: String): List<Int> {
        return numbers
            .split(Regex("[\n$delimiter]")) // Split by new lines or the specified delimiter
            .mapNotNull {
                it.toIntOrNull()
            }
    }

    private fun parseDelimiter(numbers: String): Pair<String, String> {
        return if (numbers.startsWith("//")) {
            val delimiterEndIndex = numbers.indexOf('\n')
            val delimiter = numbers.substring(2, delimiterEndIndex)
            val actualNumbers = numbers.substring(delimiterEndIndex + 1)
            Pair(delimiter, actualNumbers)
        } else {
            Pair(",", numbers)
        }
    }
}