package june30DaysChallenge

import java.util.*


/**
 * Cheapest Flights Within K Stops
 *
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v
 * with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops.
 *
 * If there is no such route, output -1.
 */
fun main(args: Array<String>) {
    val n = 3
    val edges = arrayOf(
            intArrayOf(0, 1, 100),
            intArrayOf(1, 2, 100),
            intArrayOf(0, 2, 500)
    )
    val src = 0
    val dst = 2
    val k = 0
    println(Leetcode30DayChallenge14.findCheapestPrice(n, edges, src, dst, k))
}

object Leetcode30DayChallenge14 {

    // Copied from: https://massivealgorithms.blogspot.com/2018/04/leetcode-787-cheapest-flights-within-k.html
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val prices = HashMap<Int, MutableMap<Int, Int>>()
        for (f in flights) {
            if (!prices.containsKey(f[0])) prices[f[0]] = HashMap()
            prices[f[0]]!![f[1]] = f[2]
        }
        val pq = PriorityQueue<IntArray>(Comparator { a, b -> a[0].compareTo(b[0]) })
        pq.add(intArrayOf(0, src, k + 1))
        while (!pq.isEmpty()) {
            val top = pq.remove()
            val price = top[0]
            val city = top[1]
            val stops = top[2]
            if (city == dst) return price
            if (stops > 0) {
                val adj: Map<Int, Int> = prices.getOrDefault(city, HashMap())
                for (a in adj.keys) {
                    pq.add(intArrayOf(price + adj[a]!!, a, stops - 1))
                }
            }
        }
        return -1
    }
}