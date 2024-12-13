package day10

import printAnswers

fun main() {
    fun part1(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(10, ::part1, isTest = true)
}
