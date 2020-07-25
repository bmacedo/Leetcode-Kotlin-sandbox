package challenges.july30DaysChallenge


/**
 * Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 */
fun main(args: Array<String>) {
    val x = 2.0
    val n = -3
    println(Leetcode30DayChallenge16.myPow(x, n))
}


object Leetcode30DayChallenge16 {

    fun myPow(x: Double, n: Int): Double {
        if (n == 0 || x == 1.0) return 1.0
        if (x == 0.0) return 0.0

        val temp = myPow(x, n / 2)
        val subResult = temp * temp
        return when {
            n % 2 == 0 -> subResult
            n < 0 -> subResult / x
            else -> x * subResult
        }
    }
}
