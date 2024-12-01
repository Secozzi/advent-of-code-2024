package day14

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    // Test
    val test = readInput(14, isTest = true)
    println("test=${part1(test)}")

    // Read the input
    val input = readInput(14)
    // println("answer=${part1(input)}")
}
