package challenges.april30DaysChallenge

/**
 * Best Time to Buy and Sell Stock II
 *
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
fun main(args: Array<String>) {
//    val input = intArrayOf(7,1,5,3,6,4)
//    val input = intArrayOf(1,2,3,4,5)
    val input = intArrayOf(7,6,4,3,1)
    println(Leetcode30DayChallenge5.maxProfit(input))
}

object Leetcode30DayChallenge5 {

    var profit = 0
    var holding = false
    var buyPrice = 0

    fun maxProfit(prices: IntArray): Int {

        for (i in 0 until prices.size - 1) {
            if (prices[i + 1] > prices[i] && !holding) {
                buy(prices[i])
            } else if (prices[i + 1] < prices[i] && holding) {
                sell(prices[i])
            }
        }

        if (holding) {
            sell(prices[prices.lastIndex])
        }

        return profit
    }

    private fun sell(price: Int) {
        profit += price - buyPrice
        holding = false
    }

    private fun buy(price: Int) {
        buyPrice = price
        holding = true
    }
}
