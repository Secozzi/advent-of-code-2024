package day02

import printAnswers

fun main() {
    fun part2(input: List<String>): Long {
        return input.count { line ->
            val numbers = line.split(" ").map(String::toInt)

            val toCheck = sequence {
                yield(numbers)
                numbers.indices.forEach { index ->
                    yield(numbers.filterIndexed { i, _ -> i != index })
                }
            }

            toCheck.any { it.isSafe() }
        }.toLong()
    }

    printAnswers(2, ::part2, isTest = false)
}
