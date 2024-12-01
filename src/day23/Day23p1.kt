package day23

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    // Test
    val test = readInput(23, isTest = true)
    println("test=${part1(test)}")

    // Read the input
    val input = readInput(23)
    // println("answer=${part1(input)}")
}
