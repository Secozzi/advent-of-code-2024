import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: Int, isTest: Boolean = false): List<String> {
    val dayStr = day.toString().padStart(2, '0')
    val suffix = if (isTest) "_test.txt" else ".txt"
    return Path("src/day$dayStr/Day$dayStr$suffix").readText().trim().lines()
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
