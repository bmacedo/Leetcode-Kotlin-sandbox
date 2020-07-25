package challenges.may30DaysChallenge

/**
 * Majority Element
 *
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(3,2,3)
    println(Leetcode30DayChallenge6.majorityElement(input))
}

object Leetcode30DayChallenge6 {

    // O(n) time, O(1) space, Boyer-Moore voting algorithm
    // Will only work because we know for sure that there is always
    // one element that will appear more than n/2 times.
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate: Int? = null
        nums.forEach { num ->
            if (count == 0) candidate = num
            count += if (num == candidate) 1 else -1
        }
        return candidate!!
    }

    // O(n) time, O(n) space, single pass
    fun majorityElementHashMap(nums: IntArray): Int {
        val hash = HashMap<Int, Int>()
        var maxCount = 0
        var result: Int? = null
        nums.forEach { num ->
             val count = hash.getOrDefault(num, 0) + 1
            hash[num] = count
            if (count > maxCount) {
                maxCount = count
                result = num
            }
        }
        return result!!
    }
}


