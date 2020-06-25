package june30DaysChallenge


/**
 * Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 *
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * - You must not modify the array (assume the array is read only).
 * - You must use only constant, O(1) extra space.
 * - Your runtime complexity should be less than O(n2).
 * - There is only one duplicate number in the array, but it could be repeated more than once.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(3, 1, 3, 4, 2)
    println(Leetcode30DayChallenge25.findDuplicate(input))
}

object Leetcode30DayChallenge25 {

    fun findDuplicate(nums: IntArray): Int {
        var slowPointer = nums[0]
        var fastPointer = nums[0]

        do {
            slowPointer = nums[slowPointer]
            fastPointer = nums[nums[fastPointer]]
        } while (slowPointer != fastPointer)

        var aPointer = nums[0]
        var bPointer = slowPointer

        while (aPointer != bPointer) {
            aPointer = nums[aPointer]
            bPointer = nums[bPointer]
        }

        return aPointer
    }
}
