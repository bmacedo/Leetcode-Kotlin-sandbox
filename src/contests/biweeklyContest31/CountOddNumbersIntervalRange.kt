package contests.biweeklyContest31

/**
 * Count Odd Numbers in an Interval Range
 *
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 */
fun main(args: Array<String>) {
    val low = 21
    val high = 22
    println(CountOddNumbersIntervalRange.countOdds(low, high))
}

object CountOddNumbersIntervalRange {

    fun countOdds(low: Int, high: Int): Int {
        // low is odd and high is even
        // low is even and high is even
        // low is odd and high is odd
        // low is even and high is odd
        val diff = high - low
        return diff / 2 + if (diff % 2 == 1) 1 else 0 + if (low % 2 == 1) 1 else 0
    }
}