package day04

import printAnswers

fun main() {
    fun IntRange.dropLast(n: Int): IntRange {
        return IntRange(start = start, endInclusive = endInclusive - n)
    }

    fun part2(input: List<String>): Long {
        val grid = input.map(String::toCharArray)

        return grid.first().indices.dropLast(2).sumOf { x ->
            grid.indices.dropLast(2).count { y ->
                val firstDiagonal = (grid[y][x] == 'M' && grid[y + 2][x + 2] == 'S') || (grid[y][x] == 'S' && grid[y + 2][x + 2] == 'M')
                val secondDiagonal = (grid[y + 2][x] == 'M' && grid[y][x + 2] == 'S') || (grid[y + 2][x] == 'S' && grid[y][x + 2] == 'M')

                grid[y + 1][x + 1] == 'A' && firstDiagonal && secondDiagonal
            }
        }.toLong()
    }

    printAnswers(4, ::part2, isTest = false)
}
