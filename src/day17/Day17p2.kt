package day17

import printAnswers

fun main() {
    fun part2(input: List<String>): Long {
        return input.size.toLong()
    }
    
    printAnswers(17, ::part2, isTest = true)
}
