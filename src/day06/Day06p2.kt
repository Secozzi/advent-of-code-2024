package day06

import printAnswers

fun main() {
    fun hasLoop(grid: List<List<Char>>, x: Int, y: Int, dir: Direction): Boolean {
        var currentX = x
        var currentY = y
        var direction = dir
        val visited = mutableListOf<Triple<Int, Int, Direction>>()

        while (true) {
            visited.add(Triple(currentX, currentY, direction))

            if (isNextObstacle(grid, currentX, currentY, direction)) {
                direction = direction.getNext()
            } else {
                currentX += direction.dx
                currentY -= direction.dy
            }

            if (visited.contains(Triple(currentX, currentY, direction))) {
                return true
            }

            if (isOnEdge(grid, currentX, currentY, direction)) {
                return false
            }
        }
    }

    fun part2(input: List<String>): Long {
        val grid = input.map(String::toMutableList)

        val (startX, startY) = getStartPos(grid)
        val direction = Direction.Up

        val visitedList = getPositions(grid, startX, startY, direction) - Pair(startX, startY)

        var count = 0
        visitedList.forEachIndexed { index, (x, y) ->
            grid[y][x] = '#'
            if (hasLoop(grid, startX, startY, direction)) {
                count++
            }
            grid[y][x] = '.'

            val progress = (index + 1) * 100f / visitedList.size
            print("\r Progress: %.2f%%".format(progress))
        }
        println()

        return count.toLong()
    }

    printAnswers(6, ::part2, isTest = false)
}
