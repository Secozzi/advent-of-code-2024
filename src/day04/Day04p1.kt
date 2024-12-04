package day04

import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun wordCount(grid: List<CharArray>, word: String): Int {
        val directions = listOf(
            Pair(-1, -1), Pair(0, -1), Pair( 1, -1),
            Pair(-1,  0),              Pair( 1,  0),
            Pair(-1,  1), Pair(0,  1), Pair( 1,  1),
        )

        fun isWordInDirection(x: Int, y: Int, dx: Int, dy: Int): Boolean {
            word.forEachIndexed { index, ch ->
                val newX = x + dx * index
                val newY = y + dy * index

                if (newX >= grid.first().size || newX < 0) return false
                if (newY >= grid.size || newY < 0) return false
                if (grid[newY][newX] != ch) return false
            }

            return true
        }

        return grid.first().indices.sumOf { x ->
            grid.indices.sumOf { y ->
                directions.count { (dx, dy) -> isWordInDirection(x, y, dx, dy) }
            }
        }
    }

    fun part1(input: List<String>): Int {
        val grid = input.map(String::toCharArray)

        return wordCount(grid, "XMAS")
    }

    // Test
    val test = readInput(4, isTest = true)
    println("test=${part1(test)}")

    // Final solution - 2593
    val input = readInput(4)
    val time = measureTimeMillis {
        println("answer=${part1(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
