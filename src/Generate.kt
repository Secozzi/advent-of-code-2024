import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.createFile
import kotlin.io.path.writeText

fun main() {
    (1..25).forEach { day ->
        val dayStr = day.toString().padStart(2, '0')
        val basePath = "src/day$dayStr"

        Path(basePath).createDirectory()
        Path("$basePath/Day$dayStr.txt").createFile()
        Path("$basePath/Day${dayStr}_test.txt").createFile()

        val fileTemplate: (Int, String) -> String = { part, d ->
            $$"""
                package day$$d

                import readInput

                fun main() {
                    fun part$$part(input: List<String>): Int {
                        return input.size
                    }

                    // Test
                    val test = readInput($$day, isTest = true)
                    println("test=${part$$part(test)}")

                    // Read the input
                    val input = readInput($$day)
                    // println("answer=${part$$part(input)}")
                }
                
            """.trimIndent()
        }

        (1..2).forEach { part ->
            val body = fileTemplate(part, dayStr)
            Path("$basePath/Day${dayStr}p$part.kt").createFile().writeText(body)
        }
    }
}