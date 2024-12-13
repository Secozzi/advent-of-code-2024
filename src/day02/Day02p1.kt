package day02

import printAnswers
import kotlin.math.abs

fun List<Int>.isSafe(): Boolean {
    val isIncreasing = this[1] > this[0]

    return zipWithNext().none { (c, n) ->
        c == n || abs(c - n) > 3 || n > c != isIncreasing
    }
}

fun main() {
    fun part1(input: List<String>): Long {
        return input.count { line ->
            val numbers = line.split(" ").map(String::toInt)
            numbers.isSafe()
        }.toLong()
    }

    printAnswers(2, ::part1, isTest = false)
}
