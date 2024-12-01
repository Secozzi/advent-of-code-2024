package day01

import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val list = input.map { it.split("   ").map(String::toInt) }
        val left = list.map { it.first() }.sorted()
        val right = list.map { it.last() }.sorted()

        return left.zip(right).sumOf { (leftNum, rightNum) ->
            abs(leftNum - rightNum)
        }
    }

    // Test
    val test = readInput(1, isTest = true)
    println("test=${part1(test)}")

    // Read the input
    val input = readInput(1)
    println("answer=${part1(input)}")
}
