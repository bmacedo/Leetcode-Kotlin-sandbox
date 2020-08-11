package challenges.august30DaysChallenge

/**
 * H-Index
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a
 * function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers
 * have at least h citations each, and the other N − h papers have no more than h citations each."
 */
fun main(args: Array<String>) {
    val citations = intArrayOf(3, 0, 6, 1, 5)
    println(Leetcode30DayChallenge11.hIndex(citations))
}

object Leetcode30DayChallenge11 {

    // O(n log n) time, O(1) space
    fun hIndex(citations: IntArray): Int {
        val n = citations.size
        citations.sortDescending()
        for (i in 0 until n) {
            if (i >= citations[i]) return i
        }
        return n
    }

    // O(n) time, O(n) space
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