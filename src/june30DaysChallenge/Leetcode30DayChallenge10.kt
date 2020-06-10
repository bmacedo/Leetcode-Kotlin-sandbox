package june30DaysChallenge

/**
 * Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 */
fun main(args: Array<String>) {
    val list = intArrayOf(1, 3, 5, 6)
    val target = 2
    println(Leetcode30DayChallenge10.searchInsert(list, target))
}

object Leetcode30DayChallenge10 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            val mid = start + ((end - start) ushr 1)
            when {
                nums[mid] == target -> return mid
                nums[mid] > target -> end = mid - 1
                else -> start = mid + 1
            }
        }
        return start
    }
}