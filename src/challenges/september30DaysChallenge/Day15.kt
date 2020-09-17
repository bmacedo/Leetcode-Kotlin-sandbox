package challenges.september30DaysChallenge

/**
 * Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from
 * left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 */
fun main(args: Array<String>) {
    println(Day15.lengthOfLastWord("hello world"))
}

object Day15 {
    fun lengthOfLastWord(s: String): Int {
        return s.split(" ")
                .lastOrNull { it.isNotEmpty() }
                ?.length ?: 0
    }
}