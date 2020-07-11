package biweeklyContest30

/**
 * Range Sum of Sorted Subarray Sums
 *
 * Given the array nums consisting of n positive integers.
 *
 * You computed the sum of all non-empty continous subarrays from the array and then sort them in non-decreasing order,
 * creating a new array of n * (n + 1) / 2 numbers.
 *
 * Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array.
 *
 * Since the answer can be a huge number return it modulo 10^9 + 7.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(8, 53, 22, 49, 65, 50, 28, 50, 69, 68, 64, 14, 17, 12, 69, 2, 11, 2, 96, 32, 96, 51, 58, 87, 36, 53, 45, 85, 51, 34, 93, 10, 98, 21, 76, 32, 95, 27, 6, 98, 7, 66, 9, 89, 58, 32, 58, 91, 100, 98, 85, 18, 77, 81, 66, 38, 2, 77, 19, 45, 86, 46, 47, 39, 65, 83, 89, 33, 18, 3, 62, 94, 26, 78, 51, 44, 61, 39, 57, 18, 61, 38, 90, 43, 45, 82, 78, 49, 51, 75, 52, 90, 65, 39, 87, 97, 73, 31, 25, 56, 28, 34, 66, 22, 66, 18, 77, 67, 97, 69, 100, 65, 83, 61, 44, 34, 56, 39, 59, 84, 68, 7, 94, 25, 33, 59, 89, 9, 3, 26, 77, 14, 33, 1, 28, 24, 80, 23, 85, 47, 79, 35, 2, 87, 85, 3, 3, 78, 22, 40, 31, 51, 64, 95, 47, 46, 12, 75, 56, 15, 90, 4, 99, 23, 2, 77, 69, 35, 46, 95, 27, 50, 26, 41, 24, 23, 64, 85, 20, 79, 76, 65, 53, 76, 81, 30, 1, 7, 56, 78, 5, 83, 83, 83, 18, 65, 11, 54, 40, 43, 82, 81, 80, 25, 92, 8, 44, 18, 41, 85, 96, 36, 63, 62, 78, 43, 35, 83, 10, 59, 97, 21, 14, 66, 34, 72, 92, 52, 78, 58, 54, 86, 21, 78, 54, 99, 17, 88, 85, 100, 15, 75, 99, 15, 24, 96, 62, 38, 88, 94, 13, 88, 98, 55, 34, 36, 15, 82, 46, 66, 69, 10, 2, 6, 78, 2, 100, 18, 16, 53, 50, 62, 4, 41, 81, 18, 11, 90, 51, 83, 75, 96, 29, 7, 27, 53, 4, 7, 77, 52, 17, 72, 94, 91, 39, 53, 52, 70, 8, 96, 58, 70, 19, 72, 17, 83, 27, 76, 22, 12, 74, 61, 37, 35, 33, 28, 52, 88, 2, 82, 7, 68, 100, 100, 9, 2, 82, 37, 20, 99, 19, 98, 65, 18, 15, 43, 1, 95, 42, 19, 43, 75, 97, 9, 12, 48, 27, 33, 58, 43, 88, 63, 61, 69, 68, 11, 11, 41, 57, 50, 100, 52, 70, 62, 71, 55, 67, 10, 29, 19, 83, 52, 66, 41, 19, 10, 19, 20, 5, 50, 83, 73, 15, 86, 9, 68, 35, 73, 39, 46, 86, 94, 62, 52, 76, 41, 96, 86, 80, 60, 66, 45, 30, 100, 65, 5, 93, 50, 47, 44, 66, 1, 32, 74, 10, 61, 15, 48, 56, 99, 80, 32, 70, 4, 67, 65, 15, 6, 73, 46, 6, 47, 24, 44, 35, 63, 62, 97, 54, 1, 83, 99, 31, 84, 84, 62, 96, 93, 45, 88, 93, 21, 6, 98, 95, 62, 68, 85, 22, 50, 90, 37, 88, 75, 62, 28, 4, 91, 59, 80, 77, 86, 23, 79, 57, 41, 75, 42, 56, 73, 99, 81, 19, 66, 55, 51, 31, 48, 49, 38, 31, 28, 33, 31, 69, 76, 48, 59, 31, 77, 44, 80, 82, 19, 42, 32, 19, 98, 33, 71, 23, 69, 91, 91, 77, 15, 58, 62, 27, 89, 24, 77, 46, 78, 32, 91, 12, 70, 64, 27, 38, 50, 35, 66, 26, 46, 53, 41, 94, 3, 6, 25, 26, 78, 21, 72, 59, 11, 33, 65, 37, 89, 63, 54, 41, 87, 96, 90, 90, 50, 7, 15, 8, 43, 21, 98, 35, 79, 93, 72, 57, 40, 71, 54, 62, 48, 29, 87, 12, 93, 11, 81, 12, 65, 3, 85, 75, 66, 43, 94, 77, 13, 73, 31, 3, 6, 13, 94, 40, 12, 76, 51, 91, 17, 99, 74, 79, 68, 26, 36, 38, 21, 24, 76, 29, 18, 17, 30, 34, 64, 39, 19, 95, 79, 35, 27, 11, 18, 85, 53, 24, 26, 76, 3, 45, 69, 85, 62, 87, 17, 97, 95, 35, 11, 93, 90, 80, 89, 36, 77, 95, 29, 1, 19, 27, 95, 74, 87, 1, 54, 17, 19, 63, 69, 6, 65, 41, 29, 86, 23, 59, 41, 86, 57, 30, 84, 82, 94, 36, 87, 91, 25, 13, 45, 63, 35, 46, 69, 76, 37, 28, 37, 71, 51, 9, 23, 49, 15, 76, 84, 13, 67, 18, 92, 59, 19, 55, 34, 94, 69, 25, 98, 23, 95, 9, 34, 57, 42, 49, 66, 7, 45, 50, 95, 93, 50, 71, 17, 99, 91, 92, 70, 73, 20, 84, 5, 40, 79, 57, 67, 98, 74, 54, 27, 60, 27, 51, 12, 13, 69, 52, 16, 65, 87, 60, 96, 84, 22, 5, 26, 30, 31, 13, 77, 49, 53, 9, 71, 28, 68, 26, 28, 63, 12, 25, 13, 66, 17, 78, 25, 71, 74, 67, 82, 80, 56, 77, 51, 83, 34, 87, 61, 82, 81, 78, 4, 45, 45, 99, 27, 90, 83, 5, 26, 57, 28, 67, 88, 28, 1, 19, 31, 59, 61, 12, 78, 36, 84, 38, 51, 43, 95, 93, 86, 92, 39, 86, 12, 79, 16, 64, 48, 79, 80, 84, 12, 30, 18, 53, 31, 3, 63, 37, 19, 67, 82, 48, 95, 87, 19, 15, 66, 42, 41, 88, 93, 10, 47, 25, 26, 38, 67, 90, 55, 84, 93, 95, 49, 51, 5, 19, 57, 10, 37, 81, 85, 20, 68, 25, 78, 63, 45, 20, 75, 20, 74, 55, 34, 95, 28, 15, 21, 18, 57, 69, 55, 23, 5, 39, 97, 61, 74, 11, 88, 47, 83, 13, 13, 64, 32, 67, 6, 4, 91, 88, 76, 12, 60, 34, 95, 75, 33, 90, 72, 49, 21, 31, 81, 16, 87, 75, 94, 100, 67, 21, 64, 84, 81, 32, 2, 29, 19, 91, 77, 87, 99, 19, 82, 20, 98, 76, 80, 23, 9, 14, 36, 13, 35, 80, 60, 74, 100, 34, 75, 54, 6, 91, 10, 19, 58, 8, 45, 43, 33, 82, 53, 50, 3, 38, 84, 31, 28, 100, 12, 76, 93, 19, 32, 67, 28, 58, 41, 2, 98, 33, 54, 75, 67, 71, 17)
    println(RangeSumSortedSubarraySums.rangeSum(input, 1000, 728, 897))
}

object RangeSumSortedSubarraySums {

    private val MAX = Math.pow(10.0, 9.0).toLong() + 7
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val subSetsSums = subsets(nums)
        val sublist = subSetsSums.subList(left - 1, right)
        return sublist.sum().rem(MAX).toInt()
    }

    private fun subsets(nums: IntArray): List<Long> {
        val sums = mutableListOf<Long>()
        if (nums.isNotEmpty()) {
            for (count in 0 until nums.size) {
                var i = 0
                while (i + count < nums.size) {
                    var sum = 0L
                    for (j in i..i + count) sum += nums[j]
                    sums.add(sum)
                    i++
                }
            }
        }
        return sums.sorted()
    }
}