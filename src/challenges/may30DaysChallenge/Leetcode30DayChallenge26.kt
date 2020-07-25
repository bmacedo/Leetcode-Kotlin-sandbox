package challenges.may30DaysChallenge


/**
 * Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(0, 0, 1, 0, 0, 0, 1, 1)
    println(Leetcode30DayChallenge26.findMaxLength(input))
}

object Leetcode30DayChallenge26 {

    // the idea here is to increase a counter for every one
    // and decrease it for every zero. If the counter is ever zero, it means that
    // we found out the same number of zeros and ones starting from the first element.
    // However, the smart move here is that if we ever encounter the same counter value
    // twice, it means that the number of 1's and 0's between those elements, is also equal!
    // So we can store the counts we've seen so far, together with the indexes pointing to the
    // location where we found them in the array. If we encounter the same count again, we calculate
    // the length of the current index minus the stored index and keep that if it was the largest
    // length we've seen so far.
    // O(n) time, O(n) space.
    fun findMaxLength(nums: IntArray): Int {
        val hash = HashMap<Int, Int>() // <Count, Index>
        var count = 0
        var maxLen = 0
        nums.forEachIndexed { index, num ->
            if (num == 1) count++ else count--

            if (hash[count] != null) {
                val len = index - hash[count]!!
                if (maxLen < len) maxLen = len
            } else {
                hash[count] = index
            }

            if (count == 0) {
                val len = index + 1
                if (maxLen < len) maxLen = len
            }
        }
        return maxLen
    }

    // Brute force approach. O(n square)
    fun findMaxLengthSlow(nums: IntArray): Int {
        val count = IntArray(nums.size) { 0 }
        val len = IntArray(nums.size) { 0 }
        var maxLen = 0

        for (i in nums.indices) {
            for (j in 0..i) {
                if (nums[i] == 1) count[j]++ else count[j]--
                if (count[j] == 0) {
                    len[j] = Math.max(len[j], i - j + 1)
                    if (len[j] > maxLen) maxLen = len[j]
                }
            }
        }
        return maxLen
    }
}

