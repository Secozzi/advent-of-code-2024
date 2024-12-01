package day01

import readInput
import kotlin.system.measureTimeMillis

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

    // Final solution
    val input = readInput(1)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
