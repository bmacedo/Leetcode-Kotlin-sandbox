package practice.arrays101

/**
 * Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * -    The number of elements initialized in nums1 and nums2 are m and n respectively.
 * -    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 *      additional elements from nums2.
 */
fun main(args: Array<String>) {
    val nums1 = intArrayOf(1)
    val nums2 = intArrayOf()
    val m = 1
    val n = 0
    MergeSortedArrays.merge(nums1, m, nums2, n)
    println(nums1.toList())
}

object MergeSortedArrays {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var current = nums1.lastIndex

        while (current >= 0) {
            if (i in nums1.indices && j in nums2.indices && nums1[i] > nums2[j]) {
                nums1[current] = nums1[i]
                i--
            } else if (j in nums2.indices) {
                nums1[current] = nums2[j]
                j--
            } else if (i in nums1.indices) {
                nums1[current] = nums1[i]
                i--
            }
            current--
        }
    }
}