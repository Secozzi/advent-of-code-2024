package day21

import printAnswers

fun main() {
    fun part1(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(21, ::part1, isTest = true)
}
