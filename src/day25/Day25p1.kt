package day25

import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    // Test
    val test = readInput(25, isTest = true)
    println("test=${part1(test)}")
    return

    // Final solution
    val input = readInput(25)
    val time = measureTimeMillis {
        println("answer=${part1(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
