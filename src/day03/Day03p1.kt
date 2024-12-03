package day03

import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun part1(input: List<String>): Int {
        val mulRegex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

        return input.flatMap(mulRegex::findAll).sumOf {
            it.groupValues[1].toInt() * it.groupValues[2].toInt()
        }
    }

    // Test
    val test = readInput(3, isTest = true)
    println("test=${part1(test)}")

    // Final solution
    val input = readInput(3)
    val time = measureTimeMillis {
        println("answer=${part1(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
