package day08

import com.github.michaelbull.itertools.combinations
import readInput
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.system.measureTimeMillis

fun main() {
    fun getAntiNodes(pos: Pair<Position, Position>): Pair<Sequence<Position>, Sequence<Position>> {
        val (p1, p2) = pos

        val seq1 = generateSequence(p1) { it + (p2 - p1) }
        val seq2 = generateSequence(p1 - (p2 - p1)) { it - (p2 - p1) }

        return Pair(seq1, seq2)
    }

    fun part2(input: List<String>): Int {
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
    }

    // Test
    val test = readInput(8, isTest = true)
    println("test=${part2(test)}")

    // Final solution
    val input = readInput(8)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
