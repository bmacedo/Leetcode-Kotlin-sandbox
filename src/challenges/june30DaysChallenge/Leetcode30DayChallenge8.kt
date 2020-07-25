package challenges.june30DaysChallenge

/**
 * Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 */
fun main(args: Array<String>) {
    val input = 16
    println(Leetcode30DayChallenge8.isPowerOfTwo(input))
}

object Leetcode30DayChallenge8 {

    // O(sizeOf(n))
    fun isPowerOfTwoClever(n: Int): Boolean {
        return (n > 0 && (n and n - 1) == 0)
    }

    // O(sizeof(n)). Accepted.
    fun isPowerOfTwo(n: Int): Boolean {
        var k = 0
        var result = 1
        while (result in 1..n) {
            result = 1 shl k
            if (result == n) return true
            k++
        }
        return false
    }
}