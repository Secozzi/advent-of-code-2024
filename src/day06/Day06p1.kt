package day06

import printAnswers

enum class Direction(val dx: Int, val dy: Int) {
    Up(0, 1),
    Right(1, 0),
    Down(0, -1),
    Left(-1, 0);

    fun getNext(): Direction {
        return entries[(ordinal + 1) % entries.size]
    }
}

fun isOnEdge(grid: List<List<Char>>, x: Int, y: Int, direction: Direction): Boolean {
    return when (direction) {
        Direction.Up -> y == 0
        Direction.Right -> x == grid.first().size - 1
        Direction.Down -> y == grid.size - 1
        Direction.Left -> x == 0
    }
}

fun isNextObstacle(grid: List<List<Char>>, x: Int, y: Int, direction: Direction): Boolean {
    val newX = x + direction.dx
    val newY = y - direction.dy

    return grid[newY][newX] == '#'
}

fun getPositions(grid: List<List<Char>>, x: Int, y: Int, dir: Direction): List<Pair<Int, Int>> {
    val visited = mutableSetOf<Pair<Int, Int>>()

    var currentX = x
    var currentY = y
    var direction = dir

    while (true) {
        visited.add(currentX to currentY)

        if (isNextObstacle(grid, currentX, currentY, direction)) {
            direction = direction.getNext()
        } else {
            currentX += direction.dx
            currentY -= direction.dy
        }

        if (isOnEdge(grid, currentX, currentY, direction)) {
            visited.add(currentX to currentY)
            return visited.toList()
        }
    }
}

fun getStartPos(grid: List<List<Char>>): Pair<Int, Int> {
    val startRow = grid.first { chars -> chars.contains('^') }
    return Pair(startRow.indexOf('^'), grid.indexOf(startRow))
}

fun main() {
    fun part1(input: List<String>): Long {
        val grid = input.map(String::toList)

        val (startX, startY) = getStartPos(grid)
        val direction = Direction.Up

        return getPositions(grid, startX, startY, direction).size.toLong()
    }

    printAnswers(6, ::part1, isTest = false)
}
