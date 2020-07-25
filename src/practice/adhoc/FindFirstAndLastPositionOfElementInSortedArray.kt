package practice.adhoc

/**
 * Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position
 * of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 */
fun main(args: Array<String>) {
    val input = intArrayOf(5, 7, 7, 8, 8)
    println(FindFirstAndLastPositionOfElementInSortedArray.searchRange(input, 8).toList())
}

object FindFirstAndLastPositionOfElementInSortedArray {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        var firstPosition = -1
        var lastPosition = -1

        if (nums.isNotEmpty()) {
            // binary search first position
            var start = 0
            var end = nums.lastIndex
            while (start < end) {
                val mid = start + ((end - start) shr 1)
                if (nums[mid] >= target) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }

            if (nums[start] == target) firstPosition = start

            // binary search last position, starting from first position, if fp != -1
            if (firstPosition != -1) {
                end = nums.lastIndex
                while (start < end) {
                    // the catch here is that [mid] needs to round to the next integer
                    val mid = Math.ceil(start + ((end - start.toDouble()) / 2)).toInt()
                    if (nums[mid] <= target) {
                        start = mid
                    } else {
                        end = mid - 1
                    }
                }
                lastPosition = start
            }
        }
        return intArrayOf(firstPosition, lastPosition)
    }
}