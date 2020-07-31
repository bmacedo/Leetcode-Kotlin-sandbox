package challenges.july30DaysChallenge


/**
 * Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
fun main(args: Array<String>) {
    val n = 4
    println(Leetcode30DayChallenge31.climbStairs(n))
}


object Leetcode30DayChallenge31 {

    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1

        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}
