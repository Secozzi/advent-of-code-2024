package day18

import printAnswers

fun main() {
    fun part1(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(18, ::part1, isTest = true)
}
