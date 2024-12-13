package day09

import readInput
import kotlin.system.measureTimeMillis

sealed class Block {
    data object Space : Block()
    data class File(val id: Long) : Block()
}

fun List<Block>.checkSum(): Long {
    return this.mapIndexed { index, block ->
        if (block is Block.File) index * block.id else 0L
    }.sum()
}

fun main() {
    fun parse(diskMap: String): List<Block> {
        return "${diskMap}0".toList().chunked(2).flatMapIndexed { idx, (file, space) ->
            List(file.digitToInt()) { Block.File(idx.toLong()) } + List(space.digitToInt()) { Block.Space }
        }
    }

    fun List<Block>.getFirstSpaceIndex(): Int {
        return this.indexOfFirst { it is Block.Space }
    }

    fun List<Block>.getLastFileIndex(): Int {
        return this.indexOfLast { it is Block.File }
    }

    fun isFilled(blockList: List<Block>): Boolean {
        return blockList.getFirstSpaceIndex() > blockList.getLastFileIndex()
    }

    fun part1(input: List<String>): Long {
        val blockList = parse(input.first()).toMutableList()

        while (!isFilled(blockList)) {
            val firstSpace = blockList.getFirstSpaceIndex()
            val lastFile = blockList.getLastFileIndex()

            blockList[firstSpace] = blockList[lastFile].also { blockList[lastFile] = blockList[firstSpace] }
        }

        return blockList.checkSum()
    }

    // Test
    val test = readInput(9, isTest = true)
    println("test=${part1(test)}")

    // Final solution
    val input = readInput(9)
    val time = measureTimeMillis {
        println("answer=${part1(input)}")
    }
    if (time < 1000) {
        println("\ntook $time ms")
    } else {
        println("\ntook ${time / 1000f} s")
    }
}
