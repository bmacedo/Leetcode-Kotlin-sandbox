package challenges.may30DaysChallenge

import java.util.*

/**
 * Remove K Digits
 *
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * -    The length of num is less than 10002 and will be ≥ k.
 * -    The given num does not contain any leading zero.
 */
fun main(args: Array<String>) {
    val num = "112"
    val k = 1
    println(Leetcode30DayChallenge13.removeKdigits(num, k))
}

object Leetcode30DayChallenge13 {

    fun removeKdigits(num: String, k: Int): String {
        val stack = Stack<Char>()
        var removeCount = k

        if (num.length <= k) return "0"

        num.forEach {
            while (removeCount > 0 && stack.isNotEmpty() && stack.peek() > it) {
                stack.pop()
                removeCount--
            }
            stack.push(it)
        }
        while (removeCount > 0) {
            stack.pop()
            removeCount--
        }

        val strBuilder = StringBuilder()

        while (stack.isNotEmpty()) {
            strBuilder.append(stack.pop())
        }

        val result = strBuilder.reversed().trimStart('0').toString()
        return if (result.isEmpty()) "0" else result
    }
}


