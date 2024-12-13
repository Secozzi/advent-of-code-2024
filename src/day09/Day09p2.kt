package day09

import readInput
import kotlin.system.measureTimeMillis

sealed class SizedBlock(val length: Int) {
    class Space(length: Int) : SizedBlock(length)
    class File(length: Int, val id: Long) : SizedBlock(length)
}

fun main() {
    fun parse(diskMap: String): List<SizedBlock> {
        return "${diskMap}0".toList().chunked(2).flatMapIndexed { idx, (file, space) ->
            listOf(
                SizedBlock.File(length = file.digitToInt(), id = idx.toLong()),
                SizedBlock.Space(length = space.digitToInt()),
            )
        }
    }

    fun List<SizedBlock>.getIndexFromId(id: Long): Int {
        return this.indexOfFirst { it is SizedBlock.File && it.id == id }
    }

    fun List<SizedBlock>.getFirstAvailableSpaceIndex(size: Int): Int {
        return this.indexOfFirst { it is SizedBlock.Space && it.length >= size }
    }

    fun MutableList<SizedBlock>.swapFileAndSpace(start: Int, end: Int) {
        val spaceSize = this[start].length
        val fileSize = this[end].length

        this[start] = this[end].also { this[end] = SizedBlock.Space(length = fileSize) }

        if (spaceSize > fileSize) {
            add(start + 1, SizedBlock.Space(length = spaceSize - fileSize))
        }
    }

    fun part2(input: List<String>): Long {
        val sizedBlockList = parse(input.first()).toMutableList()

        (sizedBlockList.count { it is SizedBlock.File } - 1 downTo 0).forEach { id ->
            val lastFile = sizedBlockList.getIndexFromId(id.toLong())
            val firstSpace = sizedBlockList.getFirstAvailableSpaceIndex(sizedBlockList[lastFile].length)

            if (firstSpace > 0 && firstSpace < lastFile) {
                sizedBlockList.swapFileAndSpace(firstSpace, lastFile)
            }
        }

        val blockList = sizedBlockList.flatMap { sizedBlock ->
            when (sizedBlock) {
                is SizedBlock.File -> List(sizedBlock.length) { Block.File(id = sizedBlock.id) }
                is SizedBlock.Space -> List(sizedBlock.length) { Block.Space }
            }
        }

        return blockList.checkSum()
    }

    // Test
    val test = readInput(9, isTest = true)
    println("test=${part2(test)}")

    // Final solution
    val input = readInput(9)
    val time = measureTimeMillis {
        println("answer=${part2(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
