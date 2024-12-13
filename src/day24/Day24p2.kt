package day24

import printAnswers

fun main() {
    fun part2(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(24, ::part2, isTest = true)
}
