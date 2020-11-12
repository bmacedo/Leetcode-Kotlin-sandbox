package contests.kotlinheroes5

fun main(args: Array<String>) {
    val times = readLine()!!.toInt()
    repeat(times) {
        val (x,k) = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }
        val items = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }

        println(BlackFriday.maxProfit(k, items))
    }
}

object BlackFriday {
    fun maxProfit(k: Int, items: List<Int>): Int {
        var maxProfit: Int = 0

        val n = items.size
        val entries = (k..n).map { it to it/k }.distinct()

        entries.forEach { (x, numFreeItems) ->
            val max = items.takeLast(x).take(numFreeItems).sum()
            maxProfit = Math.max(max, maxProfit)
        }

        return maxProfit
    }
}
