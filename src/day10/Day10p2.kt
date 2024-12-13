package day10

import printAnswers

fun main() {
    fun part2(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(10, ::part2, isTest = true)
}
