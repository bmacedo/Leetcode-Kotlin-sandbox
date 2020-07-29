package challenges.july30DaysChallenge


/**
 * Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you
 * like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 *  - You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *  - After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 3, 0, 2)
    println(Leetcode30DayChallenge29.maxProfit(input))
}


object Leetcode30DayChallenge29 {

    fun maxProfit(prices: IntArray): Int {
        return when {
            prices.size <= 1 -> 0
            prices.size == 2 && prices[0] < prices[1] -> prices[1] - prices[0]
            prices.size == 2 && prices[0] >= prices[1] -> 0
            else -> calcProfit(prices)
        }
    }

    private fun calcProfit(prices: IntArray): Int {
        val dp = Array(prices.size) { IntArray(2) }.apply {
            this[0][0] = 0
            this[0][1] = -prices[0]
            this[1][0] = maxOf(this[0][0], this[0][1] + prices[1])
            this[1][1] = maxOf(this[0][1], this[0][0] - prices[1])
        }

        for (i in 2 until prices.size) {
            dp[i][0] = maxOf(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = maxOf(dp[i - 1][1], dp[i - 2][0] - prices[i])
        }

        return dp[prices.lastIndex][0]
    }
}
