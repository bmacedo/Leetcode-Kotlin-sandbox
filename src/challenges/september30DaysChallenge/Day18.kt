package challenges.september30DaysChallenge

/**
 * Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell
 * one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 */
fun main(args: Array<String>) {
    println(Day18.maxProfit(intArrayOf(7, 6, 4, 3, 2, 1)))
}

object Day18 {

    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var min = Int.MAX_VALUE
        for (i in prices.indices) {
            val currentPrice = prices[i]
            if (currentPrice < min) min = currentPrice
            maxProfit = maxOf(maxProfit, currentPrice - min)
        }
        return maxProfit
    }
}