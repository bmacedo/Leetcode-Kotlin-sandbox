package practice.adhoc

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
fun main(args: Array<String>) {
//    val input1 = intArrayOf(2,7,11,19)
//    val target = 9
//    val input1 = intArrayOf(3,2,4)
//    val target = 6
    val input1 = intArrayOf(3,3)
    val target = 6
    println(TwoSum.fasterTwoSum(input1, target).toList())
}

object TwoSum {

    // O(n square) time, O(1) space
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { index, num ->
            val lookup = target - num
            val lookupIndex = nums.indexOf(lookup)
            if (lookupIndex != -1 && lookupIndex != index) {
                return intArrayOf(index, lookupIndex)
            }
        }
        throw IllegalStateException("Not found")
    }

    // O(n) time, O(n) space
    fun fasterTwoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val lookup = target - num
            if (hashMap.containsKey(lookup)) {
                return intArrayOf(hashMap[lookup]!!, index)
            }
            hashMap[num] = index
        }
        throw IllegalStateException("Not found")
    }
}
