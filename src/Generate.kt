import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.createFile
import kotlin.io.path.writeText

fun main() {
    day@ for (day in 1..25) {
        val dayStr = day.toString().padStart(2, '0')
        val basePath = "src/day$dayStr"
        try {
            Path(basePath).createDirectory()
        } catch (e: java.nio.file.FileAlreadyExistsException) {

        }
        Path("$basePath/Day$dayStr.txt").createFile()
        Path("$basePath/Day${dayStr}_test.txt").createFile()

        val fileTemplate: (Int, String) -> String = { part, d ->
            $$"""
                package day$$d

                import readInput
                import kotlin.system.measureTimeMillis

                fun main() {
                    fun part$$part(input: List<String>): Int {
                        return input.size
                    }

                    // Test
                    val test = readInput($$day, isTest = true)
                    println("test=${part$$part(test)}")
                    return

                    // Final solution
                    val input = readInput($$day)
                    val time = measureTimeMillis {
                        println("answer=${part$$part(input)}")
                    }
                    if (time < 1000) {
                        println("\ntook $time ms")
                    } else {
                        println("\ntook ${time / 1000f} s")
                    }
                }
                
            """.trimIndent()
        }

        for (part in 1..2) {
            val body = fileTemplate(part, dayStr)
            try {
                Path("$basePath/Day${dayStr}p$part.kt").createFile().writeText(body)
            } catch (e: java.nio.file.FileAlreadyExistsException) {
                continue@day
            }
        }
    }
}