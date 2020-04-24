package thirtyDaysChallenge

import utils.BinaryMatrix
import kotlin.math.max
import java.util.HashMap


/**
 * Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 */
fun main(args: Array<String>) {
    println(Leetcode30DayChallenge23.rangeBitwiseAnd(0,1))
}

object Leetcode30DayChallenge23 {

    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var result = -1
        for (num in m..n) {
            result = result and num
            if (result == 0) break
        }
        return result
    }
}
