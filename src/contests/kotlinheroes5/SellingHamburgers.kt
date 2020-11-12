package contests.kotlinheroes5

fun main(args: Array<String>) {
    val times = readLine()!!.toInt()
    repeat(times) {
        val numClients = readLine()!!.toInt()
        val coins: List<Long> = readLine()!!.split(" ").mapNotNull { it.toLongOrNull() }

        println(SellingHamburgers.maxCoins(coins))
    }
}

object SellingHamburgers {

    fun maxCoins(coins: List<Long>): Long {
        var maxProfit: Long = 0L
        val sortedList = coins.sorted()

        for (i in sortedList.indices) {
            val m = sortedList[i]
            val profit: Long = (sortedList.size - i) * m

            maxProfit = Math.max(maxProfit, profit)
        }

        return maxProfit
    }
}
