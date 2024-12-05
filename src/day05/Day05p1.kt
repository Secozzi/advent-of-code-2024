package day05

import readInput
import kotlin.system.measureTimeMillis

fun List<Int>.isCorrect(rules: List<Pair<Int, Int>>): Boolean {
    rules.forEach { (before, after) ->
        val beforeIndex = this.indexOf(before)
        val afterIndex = this.indexOf(after)

        if (beforeIndex == -1 || afterIndex == -1) return@forEach
        if (beforeIndex > afterIndex) return false
    }

    return true
}

fun List<Int>.middle(): Int {
    return this[this.size / 2]
}

fun main() {
    fun part1(input: List<String>): Int {
        val (rulesTxt, pagesTxt) = input.joinToString("\n").split("\n\n")
        val rules = rulesTxt.lines().map { it.split("|").let { (a, b) -> a.toInt() to b.toInt() } }
        val pages = pagesTxt.lines().map { it.split(",").map(String::toInt) }

        return pages
            .filter { it.isCorrect(rules) }
            .sumOf { page ->
                page.middle()
            }
    }

    // Test
    val test = readInput(5, isTest = true)
    println("test=${part1(test)}")

    // Final solution
    val input = readInput(5)
    val time = measureTimeMillis {
        println("answer=${part1(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
