package day01

import printAnswers

fun main() {
    fun part2(input: List<String>): Long {
        val list = input.map { it.split("   ").map(String::toLong) }
        val left = list.map { it.first() }
        val right = list.map { it.last() }

        return left.sumOf { num ->
            num * right.count { it == num }
        }
    }

    printAnswers(1, ::part2, isTest = false)
}
