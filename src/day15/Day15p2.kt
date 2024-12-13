package day15

import printAnswers

fun main() {
    fun part2(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(15, ::part2, isTest = true)
}
