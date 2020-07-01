package july30DaysChallenge

/**
 * Arranging Coins
 *
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
fun main(args: Array<String>) {
    val n = 2147483647 // expect: 65535
    println(Leetcode30DayChallenge1.arrangeCoins(n))
}

object Leetcode30DayChallenge1 {

    fun arrangeCoins(n: Int): Int {
        if (n == 0) return 0
        var k = 1
        var sum = 1L
        while (sum < n) {
            k++
            sum += k
            if (sum > n) return k - 1 else if (sum == n.toLong()) return k
        }
        return k
    }
}