package day18

import printAnswers

fun main() {
    fun part2(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(18, ::part2, isTest = true)
}
