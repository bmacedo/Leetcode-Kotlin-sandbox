package june30DaysChallenge


/**
 * Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board
 * are not flipped to 'X'.
 *
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped
 * to 'X'.
 *
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(0, 1, 3, 5, 6)
    println(Leetcode30DayChallenge18.hIndex(input))
}

object Leetcode30DayChallenge18 {

    // O(log n)
    fun hIndex(citations: IntArray?): Int {
        if (citations == null) return 0
        val n = citations.size
        var mid: Int
        var start = 0
        var end = n - 1
        var res = 0
        while (start <= end) {
            mid = start + (end - start) / 2
            when {
                citations[mid] == n - mid -> return n - mid
                citations[mid] < n - mid -> start = mid + 1
                else -> {
                    res = n - mid
                    end = mid - 1
                }
            }
        }
        return res
    }

    // O(n)
    fun hIndexLinear(citations: IntArray): Int {
        val count = IntArray(citations.size + 1)
        for (c in citations) {
            if (c <= citations.size) {
                count[c]++
            } else {
                count[citations.size]++
            }
        }
        var sum = 0
        var max = 0
        for (i in count.indices) {
            sum += count[i]
            val p = citations.size - sum + count[i]
            if (i <= p) {
                max = i
            }
        }
        return max
    }


}