package day05

import printAnswers

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

    fun part2(input: List<String>): Long {
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
            .toLong()
    }

    printAnswers(5, ::part2, isTest = false)
}
