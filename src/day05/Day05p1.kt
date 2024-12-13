package day05

import printAnswers

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
    fun part1(input: List<String>): Long {
        val (rulesTxt, pagesTxt) = input.joinToString("\n").split("\n\n")
        val rules = rulesTxt.lines().map { it.split("|").let { (a, b) -> a.toInt() to b.toInt() } }
        val pages = pagesTxt.lines().map { it.split(",").map(String::toInt) }

        return pages
            .filter { it.isCorrect(rules) }
            .sumOf { page ->
                page.middle()
            }
            .toLong()
    }

    printAnswers(5, ::part1, isTest = false)
}
