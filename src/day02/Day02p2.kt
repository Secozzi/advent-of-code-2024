package day02

import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun part2(input: List<String>): Int {
        return input.count { line ->
            val numbers = line.split(" ").map(String::toInt)

            val toCheck = sequence {
                yield(numbers)
                numbers.indices.forEach { index ->
                    yield(numbers.filterIndexed { i, _ -> i != index })
                }
            }

            toCheck.any { it.isSafe() }
        }
    }

    // Test
    val test = readInput(2, isTest = true)
    println("test=${part2(test)}")

    // Final solution
    val input = readInput(2)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
