package may30DaysChallenge

import utils.TreeNode
import utils.root
import java.math.BigInteger

/**
 * Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num
 * is a perfect square else False.
 */
fun main(args: Array<String>) {
    val input = Int.MAX_VALUE
    println(Leetcode30DayChallenge9.isPerfectSquare(input))
}

object Leetcode30DayChallenge9 {

    // O(log n)
    fun isPerfectSquare(num: Int): Boolean {
        var start = 1L
        var end = num.toLong()
        while (start <= end) {
            val mid = (start + end) ushr 1
            val square = mid * mid
            when {
                square == num.toLong() -> return true
                square < num -> start = mid + 1
                else -> end = mid - 1
            }
        }
        return false
    }

    // O(sqrt n)
    fun isPerfectSquareSlow(num: Int): Boolean {
        var i = BigInteger.valueOf(0)
        var square = (i * i).longValueExact()
        while (square < num) {
            i++
            square = (i * i).longValueExact()
        }
        return square == num.toLong()
    }
}


