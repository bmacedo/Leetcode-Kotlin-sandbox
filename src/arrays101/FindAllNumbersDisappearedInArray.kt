package arrays101

import kotlin.math.abs

/**
 * Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a(i) ≤ n (n = size of array), some elements appear twice
 * and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(4,3,2,7,8,2,3,1)
    println(FindAllNumbersDisappearedInArray.findDisappearedNumbers(input))
}

object FindAllNumbersDisappearedInArray {

    // O(n) time, O(1) space
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val output = mutableListOf<Int>()
        for (i in nums.indices) {
            val value = abs(nums[i]) - 1
            if (nums[value] > 0) nums[value] = -nums[value]
        }
        for (i in nums.indices) {
            if (nums[i] > 0) output.add(i+1)
        }
        return output
    }

    // O(n) time, O(n) space
    fun findDisappearedNumbersSpacey(nums: IntArray): List<Int> {
        val output = HashSet<Int>()

        for (i in 1 .. nums.size) {
            output.add(i)
        }

        for (i in nums.indices) {
            output.remove(nums[i])
        }

        return output.toList()
    }
}