package practice.easyTopInterviewQuestions

/**
 * Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1,2,3)
    println(ContainsDuplicate.containsDuplicateMoretimeLessSpace(input))
}

object ContainsDuplicate {

    // O(n) time, O(n) space
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach { num ->
            if (set.contains(num)) return true
            set.add(num)
        }
        return false
    }

    // O(nlogn) time, O(1) space
    fun containsDuplicateMoretimeLessSpace(nums: IntArray): Boolean {
        nums.sort()
        for (i in 0 until nums.lastIndex) {
            if (nums[i] == nums[i+1]) return true
        }
        return false
    }
}