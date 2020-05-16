package biweeklyContest26

/**
 * Consecutive Characters
 *
 * Given a string s, the power of the string is the maximum length of a non-empty substring
 * that contains only one unique character.
 *
 * Return the power of the string.
 */
fun main(args: Array<String>) {
    val input = "c"
    println(ConsecutiveCharacters.maxPower(input))
}

object ConsecutiveCharacters {
    fun maxPower(s: String): Int {
        if (s.isEmpty()) return 0
        var currentChar = s[0]
        var maxCount = 1
        var count = 1
        for (i in 1 until s.length) {
            if (s[i] == currentChar) {
                count++
            } else {
                currentChar = s[i]
                count = 1
            }
            if (count > maxCount) maxCount = count
        }
        return maxCount
    }
}