package day01

import readInput
import kotlin.math.abs
import kotlin.system.measureTimeMillis

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

    // Final solution
    val input = readInput(1)
    val time = measureTimeMillis {
        println("answer=${part1(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
