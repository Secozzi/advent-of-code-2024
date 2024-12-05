package day05

import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun List<Int>.fix(rules: List<Pair<Int, Int>>): List<Int> {
        val result = toMutableList()

        rules.forEach { (before, after) ->
            val beforeIndex = result.indexOf(before)
            val afterIndex = result.indexOf(after)

            if (beforeIndex == -1 || afterIndex == -1) return@forEach
            if (beforeIndex < afterIndex) return@forEach

            result[beforeIndex] = result[afterIndex].also { result[afterIndex] = result[beforeIndex] }
        }

        return result
    }

    fun part2(input: List<String>): Int {
        val (rulesTxt, pagesTxt) = input.joinToString("\n").split("\n\n")
        val rules = rulesTxt.lines().map { it.split("|").let { (a, b) -> a.toInt() to b.toInt() } }
        val pages = pagesTxt.lines().map { it.split(",").map(String::toInt) }

        return pages
            .filterNot { it.isCorrect(rules) }
            .sumOf { page ->
                var fixed = page
                while (!fixed.isCorrect(rules)) {
                    fixed = fixed.fix(rules)
                }
                fixed.middle()
            }
    }

    // Test
    val test = readInput(5, isTest = true)
    println("test=${part2(test)}")

    // Final solution
    val input = readInput(5)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
