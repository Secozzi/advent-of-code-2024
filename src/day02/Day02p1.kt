package day02

import readInput
import kotlin.math.abs
import kotlin.system.measureTimeMillis

fun List<Int>.isSafe(): Boolean {
    val isIncreasing = this[1] > this[0]

    return zipWithNext().none { (c, n) ->
        c == n || abs(c - n) > 3 || n > c != isIncreasing
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        return input.count { line ->
            val numbers = line.split(" ").map(String::toInt)
            numbers.isSafe()
        }
    }

    // Test
    val test = readInput(2, isTest = true)
    println("test=${part1(test)}")

    // Final solution
    val input = readInput(2)
    val time = measureTimeMillis {
        println("answer=${part1(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
