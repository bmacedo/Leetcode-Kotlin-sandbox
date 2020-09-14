package challenges.september30DaysChallenge

/**
 * House Robber
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
 */
fun main(args: Array<String>) {
    println(Day14.rob(intArrayOf(2, 7, 9, 3, 1)))
}

object Day14 {
    fun rob(nums: IntArray): Int {
        if (nums.size <= 2) return nums.max() ?: 0

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp[nums.lastIndex]
    }
}