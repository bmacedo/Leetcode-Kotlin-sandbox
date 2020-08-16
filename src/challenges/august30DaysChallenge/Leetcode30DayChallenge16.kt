package challenges.august30DaysChallenge

import kotlin.test.assertEquals

/**
 * Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
fun main(args: Array<String>) {
    assertEquals(6, Leetcode30DayChallenge16.maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
    assertEquals(4, Leetcode30DayChallenge16.maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    assertEquals(0, Leetcode30DayChallenge16.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println("Success")
}

object Leetcode30DayChallenge16 {


    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var firstBuy = Int.MIN_VALUE
        var secondBuy = Int.MIN_VALUE
        var firstSell = 0
        var secondSell = 0
        for (price in prices) {
            firstBuy = maxOf(firstBuy, -price)
            firstSell = maxOf(firstSell, firstBuy + price)
            secondBuy = maxOf(secondBuy, firstSell - price)
            secondSell = maxOf(secondSell, secondBuy + price)
        }
        return secondSell
    }

    // We use left[i] to track the maximum profit for transactions before i,
    // and use right[i] to track the maximum profit for transactions after i
    fun maxProfitDivideAndConquer(prices: IntArray): Int {
        if (prices.size < 2) return 0

        //highest profit in 0 ... i
        val left = IntArray(prices.size).apply { this[0] = 0 }
        val right = IntArray(prices.size).apply { this[lastIndex] = 0 }

        // DP from left to right
        var min = prices[0]
        for (i in 1 until prices.size) {
            min = minOf(min, prices[i])
            left[i] = maxOf(left[i - 1], prices[i] - min)
        }

        // DP from right to left
        right[prices.size - 1] = 0
        var max = prices[prices.size - 1]
        for (i in prices.size - 2 downTo 0) {
            max = maxOf(max, prices[i])
            right[i] = maxOf(right[i + 1], max - prices[i])
        }

        var profit = 0
        for (i in 0 until prices.size) {
            profit = maxOf(profit, left[i] + right[i])
        }

        return profit
    }
}