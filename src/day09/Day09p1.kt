package day09

import printAnswers

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

    printAnswers(9, ::part1, isTest = false)
}
