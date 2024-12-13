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

                import printAnswers

                fun main() {
                    fun part$$part(input: List<String>): Long {
                        return input.size.toLong()
                    }
                    
                    printAnswers($$day, ::part$$part, isTest = true)
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