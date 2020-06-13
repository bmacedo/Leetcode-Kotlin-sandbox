package june30DaysChallenge

/**
 * Largest Divisible Subset
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
 * of elements in this subset satisfies:
 *      Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 4, 8)
    println(Leetcode30DayChallenge13.largestDivisibleSubset(input))
}

object Leetcode30DayChallenge13 {

    // O(n square).
    // The trick is that divisibility is transitive. So: given (a,b,c) as sorted list
    //  if (b%a == 0) and (c%b == 0) then (c%a == 0)
    //  example: (1,2,4). => (2%1 == 0); (4%2 == 0) then (4%1 == 0)
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        if (nums.isEmpty()) return emptyList()
        nums.sort()
        var max = 1 // each number is divisible by itself, so by default the min result is 1
        val dp = IntArray(nums.size) { 1 } // start the dp with 1's in all fields

        // calculate the dp table and the max
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0 && (1 + dp[j]) > dp[i]) {
                    dp[i] = 1 + dp[j]
                    if (max < dp[i]) max = dp[i]
                }
            }
        }

        // get the answer from the dp table
        var prev = -1
        val ans = mutableListOf<Int>()
        for (i in nums.lastIndex downTo 0) {
            if (dp[i] == max && (prev % nums[i] == 0 || prev == -1)) {
                ans.add(nums[i])
                prev = nums[i]
                max--
            }
        }
        return ans
    }
}