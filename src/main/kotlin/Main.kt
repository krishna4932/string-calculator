package org.example

fun main() {
    val calculator = StringCalculator()

    println("\" \"" + " -> " + calculator.add("")) // Output: 0
    println("2" + " -> " +  calculator.add("2")) // Output: 2
    println("1,8" + " -> " + calculator.add("1,8")) // Output: 9
    println("""1\n2,3""" + " -> " +  calculator.add("1\n2,3")) // Output: 6
}