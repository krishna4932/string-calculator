package org.example

fun main() {
    val calculator = StringCalculator()

    println("\" \"" + " -> " + calculator.add("")) // Output: 0
    println("2" + " -> " +  calculator.add("2")) // Output: 2
    println("1,8" + " -> " + calculator.add("1,8")) // Output: 9
    println("""1\n2,3""" + " -> " +  calculator.add("1\n2,3")) // Output: 6

    println("""//;\n1;10;11""" + " -> " + calculator.add("//;\n1;10;11")) // Output: 22
    println("""//[***]\n1***2***1001""" + " -> " + calculator.add("//[***]\n1***2***1001")) // Output: 3
}