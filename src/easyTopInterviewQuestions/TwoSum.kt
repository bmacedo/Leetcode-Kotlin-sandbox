package easyTopInterviewQuestions

/**
 * Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not
 * use the same element twice.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(2, 7, 15)
    val target = 9
    println(TwoSum.twoSum(input, target).toList())
}

object TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hash = HashMap<Int, Int>()
        nums.forEachIndexed { index, num ->
            if (hash.containsKey(target - num)) {
                return intArrayOf(hash[target-num]!!, index)
            } else {
                hash[num] = index
            }
        }
        throw RuntimeException("not found")
    }
}