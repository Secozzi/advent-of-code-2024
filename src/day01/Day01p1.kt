package day01

import printAnswers
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        val list = input.map { it.split("   ").map(String::toLong) }
        val left = list.map { it.first() }.sorted()
        val right = list.map { it.last() }.sorted()

        return left.zip(right).sumOf { (leftNum, rightNum) ->
            abs(leftNum - rightNum)
        }
    }

    printAnswers(1, ::part1, isTest = false)
}
