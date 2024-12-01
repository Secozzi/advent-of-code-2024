package day14

import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test
    val test = readInput(14, isTest = true)
    println("test=${part2(test)}")
    return

    // Final solution
    val input = readInput(14)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
