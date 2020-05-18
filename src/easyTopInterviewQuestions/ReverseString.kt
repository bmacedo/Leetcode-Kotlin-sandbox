package easyTopInterviewQuestions

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
    ReverseString.reverseString(input)
    println(input.joinToString())
}

object ReverseString {

    fun reverseString(s: CharArray) {
        var start = 0
        var end = s.lastIndex
        while (end > start) {
            val temp = s[start]
            s[start] = s[end]
            s[end] = temp
            start++
            end--
        }
    }

}