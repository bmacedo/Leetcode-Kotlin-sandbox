package practice.arrays101

/**
 * Third Maximum Number
 *
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number.
 *
 * The time complexity must be in O(n).
 */
fun main(args: Array<String>) {
    val input = intArrayOf(5, 3, 4, 4)
    println(ThirdMaximumNumber.thirdMax(input))
}

object ThirdMaximumNumber {
    fun thirdMax(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var max1: Int? = null
        var max2: Int? = null
        var max3: Int? = null
        nums.forEach { num ->
           if (max1 != null && max2 != null && max3 != null && num > max1!! && num < max2!! && num < max3!!) {
               max1 = num
           } else if (max2 != null && max3 != null && num > max2!! && num < max3!!) {
               max1 = max2
               max2 = num
           } else if (max3 != null && num > max3!!) {
               max1 = max2
               max2 = max3
               max3 = num
           } else if (max3 == null) {
               max3 = num
           } else if (max2 == null && max3 != null && num < max3!!) {
               max2 = num
           } else if (max1 == null && max2 != null && num < max2!!) {
               max1 = num
           }
        }
        return if (max1 != null) max1!! else max3!!
    }
}