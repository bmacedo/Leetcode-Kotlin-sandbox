package challenges.june30DaysChallenge

/**
 * Random Pick with Weight
 *
 * Given an array w of positive integers, where w[ i ] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2)
    val solution = Leetcode30DayChallenge5.Solution(input)
    println(solution.pickIndex())
    println(solution.pickIndex())
    println(solution.pickIndex())

    println(solution.pickIndex())
    println(solution.pickIndex())
    println(solution.pickIndex())
}

object Leetcode30DayChallenge5 {

    class Solution(w: IntArray) {

        private val wSum: IntArray = IntArray(w.size)

        init {
            var sum = 0
            for (i in w.indices) {
                sum += w[i]
                wSum[i] = sum
            }
        }

        fun pickIndex(): Int {
            val randomNo = (wSum[wSum.size - 1] * Math.random()).toInt()
            var res = -1
            var si = 0
            var ei = wSum.size - 1
            while (si <= ei) {
                val mid = si + (ei - si) / 2
                if (randomNo < wSum[mid]) {
                    res = mid
                    ei = mid - 1
                } else {
                    si = mid + 1
                }
            }
            return res
        }
    }

}