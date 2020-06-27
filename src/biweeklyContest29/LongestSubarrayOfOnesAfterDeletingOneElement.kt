package biweeklyContest29

/**
 * Longest Subarray of 1's After Deleting One Element
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 *
 * Return 0 if there is no such subarray.
 */
fun main(args: Array<String>) {
//    val input = intArrayOf(1,1,0,0,1,1,1,0,1)
    val input = intArrayOf(1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1)
    println(LongestSubarrayOfOnesAfterDeletingOneElement.longestSubarray(input))
}

object LongestSubarrayOfOnesAfterDeletingOneElement {
    fun longestSubarray(nums: IntArray): Int {
        val list = mutableListOf<Pair<Int, Int>>() // Count, Distance
        val trimmedNums = nums.dropWhile { it == 0 }

        var i = 0
        while (i in trimmedNums.indices) {
            var countOnes = 0
            var countZeros = 0
            while (i in trimmedNums.indices && trimmedNums[i] == 1) {
                countOnes++
                i++
            }
            while (i in trimmedNums.indices && trimmedNums[i] == 0) {
                countZeros++
                i++
            }
            list.add(countOnes to countZeros)
        }

        var result = list.maxBy { it.first }?.first ?: 0

        if (result > 0 && result == nums.size) return result - 1

        for (j in 0 until list.lastIndex) {
            if (list[j].second == 1) {
                val sum = list[j].first + list[j + 1].first
                result = maxOf(result, sum)
            }
        }

        return result
    }
}