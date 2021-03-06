package challenges.june30DaysChallenge


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
    val input = intArrayOf(0, 1, 3, 5, 6)
    println(Leetcode30DayChallenge18.hIndex(input))
}

object Leetcode30DayChallenge18 {

    // O(n)
    fun hIndex(citations: IntArray): Int {
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