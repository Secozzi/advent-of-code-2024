package day03

import printAnswers


fun main() {
    fun part2(input: List<String>): Long {
        val mulDoRegex = Regex("""mul\((?<first>\d{1,3}),(?<second>\d{1,3})\)|(?<check>do(n't)?\(\))""")
        var isEnabled = true

        return input.flatMap(mulDoRegex::findAll).sumOf { matchResult ->
            if (matchResult.groups["check"] != null) {
                isEnabled = matchResult.value == "do()"
                0L
            } else {
                if (isEnabled) {
                    val (first, second) = matchResult.destructured
                    first.toLong() * second.toLong()
                } else {
                    0L
                }
            }
        }
    }

    printAnswers(3, ::part2, isTest = false)
}
