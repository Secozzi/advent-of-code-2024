package day03

import printAnswers

fun main() {
    fun part1(input: List<String>): Long {
        val mulRegex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

        return input.flatMap(mulRegex::findAll).sumOf {
            it.groupValues[1].toLong() * it.groupValues[2].toLong()
        }
    }

    printAnswers(3, ::part1, isTest = false)
}
