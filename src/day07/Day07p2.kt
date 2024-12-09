package day07

import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun isValid(
        testValue: Long,
        values: List<Long>,
    ): Boolean {
        if (values.size == 1) {
            return testValue == values.first()
        }

        return isValid(testValue, listOf(values[0] + values[1]) + values.drop(2)) ||
                isValid(testValue, listOf(values[0] * values[1]) + values.drop(2)) ||
                isValid(testValue, listOf((values[0].toString() + values[1].toString()).toLong()) + values.drop(2))
    }

    fun part2(input: List<String>): Long {
        return input.sumOf { line ->
            val (testValue, values) = line.split(": ").let { strs ->
                strs[0].toLong() to strs[1].split(" ").map(String::toLong)
            }
            if (isValid(testValue, values)) testValue else 0L
        }
    }

    // Test
    val test = readInput(7, isTest = true)
    println("test=${part2(test)}")

    // Final solution
    val input = readInput(7)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
