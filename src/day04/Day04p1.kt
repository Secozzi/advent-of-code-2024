package day04

import printAnswers

fun main() {
    fun wordCount(grid: List<CharArray>, word: String): Long {
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
        }.toLong()
    }

    fun part1(input: List<String>): Long {
        val grid = input.map(String::toCharArray)

        return wordCount(grid, "XMAS")
    }

    printAnswers(4, ::part1, isTest = false)
}
