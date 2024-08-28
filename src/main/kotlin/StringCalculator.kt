package org.example

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isBlank()) return 0

        val (delimiters, actualNumbers) = parseDelimiters(numbers)
        val numberList = parseNumbers(actualNumbers, delimiters).filter { it <= 1000 }

        val negativeNumbers = numberList.filter { it < 0 }
        if (negativeNumbers.isNotEmpty()) {
            throw Exception("negatives not allowed: ${negativeNumbers.joinToString(",")}")
        }

        return numberList.sum()
    }

    private fun parseNumbers(numbers: String, delimiters: List<String>): List<Int> {
//        println(delimiters)
        val regex = delimiters.joinToString(separator = "|", prefix = "[", postfix = "]") {
            Regex.escape(it)
        }
//        println(regex)
        return numbers
            .split(Regex("[\n$regex]")) // Split by new lines or any of the specified delimiters
            .mapNotNull {
                it.toIntOrNull()
            }
    }

    private fun parseDelimiters(numbers: String): Pair<List<String>, String> {
        return if (numbers.startsWith("//")) {
            val delimiterEndIndex = numbers.indexOf('\n')
            val delimiterSection = numbers.substring(2, delimiterEndIndex)
            val delimiters = delimiterSection
                .trim('[').trim(']')
                .split("][")
            val actualNumbers = numbers.substring(delimiterEndIndex + 1)
            Pair(delimiters, actualNumbers)
        } else {
            Pair(listOf(","), numbers)
        }
    }
}
