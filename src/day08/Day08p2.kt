package day08

import com.github.michaelbull.itertools.combinations
import printAnswers
import kotlin.collections.component1
import kotlin.collections.component2

fun main() {
    fun getAntiNodes(pos: Pair<Position, Position>): Pair<Sequence<Position>, Sequence<Position>> {
        val (p1, p2) = pos

        val seq1 = generateSequence(p1) { it + (p2 - p1) }
        val seq2 = generateSequence(p1 - (p2 - p1)) { it - (p2 - p1) }

        return Pair(seq1, seq2)
    }

    fun part2(input: List<String>): Long {
        val grid = input.map(String::toList)
        val map = getFrequencyMapping(grid)

        val isInGrid: (Position) -> Boolean = { p ->
            p.x in grid.first().indices && p.y in grid.indices
        }

        return map.values.flatMap { positions ->
            positions.combinations(length = 2).map { (p1, p2) ->
                getAntiNodes(Pair(p1, p2))
            }
                .flatMap { (pPos, pNeg) ->
                    pPos.takeWhile { isInGrid(it) } + pNeg.takeWhile { isInGrid(it) }
                }
        }
            .distinct()
            .size
            .toLong()
    }

    printAnswers(8, ::part2, isTest = false)
}
