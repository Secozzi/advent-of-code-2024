package day01

import readInput

fun main() {
    fun part2(input: List<String>): Int {
        val list = input.map { it.split("   ").map(String::toInt) }
        val left = list.map { it.first() }
        val right = list.map { it.last() }

        return left.sumOf { num ->
            num * right.count { it == num }
        }
    }

    // Test
    val test = readInput(1, isTest = true)
    println("test=${part2(test)}")

    // Read the input
    val input = readInput(1)
    println("answer=${part2(input)}")
}
