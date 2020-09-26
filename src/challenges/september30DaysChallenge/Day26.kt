package challenges.september30DaysChallenge


/**
 * Teemo Attacking
 *
 * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition.
 * Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's
 * attacking, you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned
 * condition immediately.
 */
fun main(args: Array<String>) {
    println(Day26.findPoisonedDuration(intArrayOf(1, 2, 3, 4, 5), 5))
}

object Day26 {

    // O(n) time, O(n) space
    // Note: it's possible to implement a version with O(1) space
    // https://leetcode.com/problems/teemo-attacking/solution/
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if (timeSeries.isEmpty()) return 0

        val intervals = timeSeries.map { Pair(it, it + duration) }.toMutableList()

        var i = 1
        while (i < intervals.size) {
            val currentInterval = intervals[i - 1]
            if (currentInterval.second > intervals[i].first) {
                intervals[i - 1] = Pair(currentInterval.first, maxOf(currentInterval.second, intervals[i].second))
                intervals.removeAt(i)
            } else {
                i++
            }

        }

        return intervals.sumBy { it.second - it.first }
    }
}