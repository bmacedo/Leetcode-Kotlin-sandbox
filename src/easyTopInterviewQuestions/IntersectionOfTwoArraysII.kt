package easyTopInterviewQuestions

/**
 * Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *  Output: [2,2]
 *
 * Note:
 * -    Each element in the result should appear as many times as it shows in both arrays.
 * -    The result can be in any order.
 */
fun main(args: Array<String>) {
    val input1 = intArrayOf(4,9,5)
    val input2 = intArrayOf(9,4,9,8,4)
    println(IntersectionOfTwoArraysII.intersect(input1,input2).toList())
}

object IntersectionOfTwoArraysII {

    // O(nlogn) time, O(n) space
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        val output = mutableListOf<Int>()
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] == nums2[j] -> {
                    output.add(nums1[i])
                    i++
                    j++
                }
                nums1[i] < nums2[j] -> i++
                else -> j++
            }
        }
        return output.toIntArray()
    }
}