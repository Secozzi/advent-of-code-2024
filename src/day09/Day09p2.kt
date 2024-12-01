package day09

import readInput

fun main() {
    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test
    val test = readInput(9, isTest = true)
    println("test=${part2(test)}")

    // Read the input
    val input = readInput(9)
    // println("answer=${part2(input)}")
}
