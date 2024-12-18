package day07

import printAnswers

fun main() {
    fun isValid(
        testValue: Long,
        values: List<Long>,
    ): Boolean {
        if (values.size == 1) {
            return testValue == values.first()
        }

        return isValid(testValue, listOf(values[0] + values[1]) + values.drop(2)) ||
                isValid(testValue, listOf(values[0] * values[1]) + values.drop(2)) ||
                isValid(testValue, listOf((values[0].toString() + values[1].toString()).toLong()) + values.drop(2))
    }

    fun part2(input: List<String>): Long {
        return input.sumOf { line ->
            val (testValue, values) = line.split(": ").let { strs ->
                strs[0].toLong() to strs[1].split(" ").map(String::toLong)
            }
            if (isValid(testValue, values)) testValue else 0L
        }
    }

    printAnswers(7, ::part2, isTest = false)
}
