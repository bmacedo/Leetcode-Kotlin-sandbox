package challenges.june30DaysChallenge

/**
 * Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 */
fun main(args: Array<String>) {
    val input = "hello".toCharArray()
    Leetcode30DayChallenge4.reverseString(input)
    println(input)
}

object Leetcode30DayChallenge4 {

    fun reverseString(s: CharArray) {
        for (i in 0 until s.size / 2) {
            val j = s.lastIndex - i
            val temp = s[i]
            s[i] = s[j]
            s[j] = temp
        }
    }
}