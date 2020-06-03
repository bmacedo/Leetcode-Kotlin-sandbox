package june30DaysChallenge

/**
 * Two City Scheduling
 *
 * There are 2N people a company is planning to interview.
 *
 * The cost of flying the i-th person to city A is costs[i][0], and the cost of flying
 * the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
fun main(args: Array<String>) {
    val input = arrayOf(
            intArrayOf(10, 20),
            intArrayOf(30, 200),
            intArrayOf(40, 50),
            intArrayOf(30, 20)
    )
    println(Leetcode30DayChallenge3.twoCitySchedCost(input))
}

object Leetcode30DayChallenge3 {

    val hash = HashMap<Triple<Int, Int, Int>, Int>()
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        return getMinCost(0, 0, 0, costs)
    }

    private fun getMinCost(currentIndex: Int, sizeA: Int, sizeB: Int, costs: Array<IntArray>): Int {
        if (currentIndex !in costs.indices) return 0
        if (hash[Triple(currentIndex, sizeA, sizeB)] != null) return hash[Triple(currentIndex, sizeA, sizeB)]!!

        val (costA, costB) = costs[currentIndex]
        var choice1 = Int.MAX_VALUE
        var choice2 = Int.MAX_VALUE
        if (sizeA < costs.size / 2) {
            choice1 = costA + getMinCost(currentIndex + 1, sizeA + 1, sizeB, costs)
        }
        if (sizeB < costs.size / 2) {
            choice2 = costB + getMinCost(currentIndex + 1, sizeA, sizeB + 1, costs)
        }

        val result = minOf(choice1, choice2)
        hash[Triple(currentIndex, sizeA, sizeB)] = result

        return result
    }
}