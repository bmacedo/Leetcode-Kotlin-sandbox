package challenges.july30DaysChallenge


/**
 * Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 */
fun main(args: Array<String>) {
    val input = "  hello world!  "
    println(Leetcode30DayChallenge15.reverseWords(input))
}


object Leetcode30DayChallenge15 {

    fun reverseWords(s: String): String = s
            .split("\\s".toRegex())
            .filter { it.isNotBlank() }
            .reversed()
            .joinToString(" ")
}
