package day08

import com.github.michaelbull.itertools.combinations
import printAnswers
import kotlin.collections.component1
import kotlin.collections.component2

data class Position(
    val x: Int,
    val y: Int,
) {
    operator fun plus(other: Position) = Position(x + other.x, y + other.y)

    operator fun minus(other: Position) = Position(x - other.x, y - other.y)

    operator fun times(scalar: Int) = Position(x * scalar, y * scalar)
}

fun <K, V> MutableMap<K, MutableList<V>>.addToValue(key: K, value: V) {
    this.getOrPut(key) { mutableListOf() }.add(value)
}

fun getFrequencyMapping(grid: List<List<Char>>): Map<Char, List<Position>> {
    val map = mutableMapOf<Char, MutableList<Position>>()

    grid.forEachIndexed { y, line ->
        line.forEachIndexed { x, ch ->
            if (ch != '.') {
                map.addToValue(ch, Position(x, y))
            }
        }
    }

    return map
}

fun main() {
    fun part1(input: List<String>): Long {
        val grid = input.map(String::toList)
        val map = getFrequencyMapping(grid)

        return map.values.flatMap { positions ->
            positions.combinations(length = 2).flatMap { (p1, p2) ->
                listOf(
                    p1 + (p2 - p1) * 2,
                    p1 - (p2 - p1),
                )
            }
        }
            .filter { p -> p.x in grid.first().indices && p.y in grid.indices }
            .distinct()
            .size
            .toLong()
    }

    printAnswers(8, ::part1, isTest = false)
}
