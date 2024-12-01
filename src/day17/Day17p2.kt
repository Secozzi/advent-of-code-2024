package day17

import readInput

fun main() {
    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test
    val test = readInput(17, isTest = true)
    println("test=${part2(test)}")

    // Read the input
    val input = readInput(17)
    // println("answer=${part2(input)}")
}
