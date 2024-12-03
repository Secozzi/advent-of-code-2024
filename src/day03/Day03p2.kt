package day03

import readInput
import kotlin.system.measureTimeMillis


fun main() {
    fun part2(input: List<String>): Int {
        val mulDoRegex = Regex("""mul\((?<first>\d{1,3}),(?<second>\d{1,3})\)|(?<check>do(n't)?\(\))""")
        var isEnabled = true

        return input.flatMap(mulDoRegex::findAll).sumOf { matchResult ->
            if (matchResult.groups["check"] != null) {
                isEnabled = matchResult.value == "do()"
                0
            } else {
                if (isEnabled) {
                    val (first, second) = matchResult.destructured
                    first.toInt() * second.toInt()
                } else {
                    0
                }
            }
        }
    }

    // Test
    val test = readInput(3, isTest = true)
    println("test=${part2(test)}")

    // Final solution
    val input = readInput(3)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
