package challenges.august30DaysChallenge

/**
 * Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * A -> 1, B -> 2, C -> 3, ..., Z -> 26, AA -> 27, AB -> 28, ...
 * AZ -> 52
 * BA -> 53
 * BB -> 54
 */
fun main(args: Array<String>) {
    val input = "ZY"
    println(Leetcode30DayChallenge10.titleToNumber(input))
}

object Leetcode30DayChallenge10 {

    fun titleToNumber(s: String): Int {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var sum = 0
        for (i in s.lastIndex downTo 0) {
            val pow = Math.pow(26.0, s.lastIndex - i.toDouble())
            val digit = alphabet.indexOf(s[i]) + 1
            sum += pow.toInt() * digit
        }
        return sum
    }
}