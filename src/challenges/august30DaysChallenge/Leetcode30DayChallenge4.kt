package challenges.august30DaysChallenge

/**
 * Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Follow up: Could you solve it without loops/recursion?
 */
fun main(args: Array<String>) {
    val input = 4
    println(Leetcode30DayChallenge4.isPowerOfFourFaster(input))
}

object Leetcode30DayChallenge4 {

    // This is O(1) since the maximum # of iterations will be 32, the size of Int.
    fun isPowerOfFour(num: Int): Boolean {
        if (num <= 0) return false
        if (num == 1) return true

        var temp = num
        var countZeros = 0
        var hasSeenOne = false
        while (temp != 0) {
            val lastDigit = temp and 1
            when {
                lastDigit == 0 -> countZeros++
                hasSeenOne -> return false
                else -> hasSeenOne = true
            }
            temp = temp ushr 1
        }

        return countZeros > 0 && countZeros % 2 == 0
    }

    // Follow up: using only bitwise operations without any loops.
    // Explanation:
    //  To check that number is power of 4, we need to check 3 conditions:
    //  - Number is positive.
    //  - Number is power of 2.
    //  - This power of 2 is even power.
    //
    // First condition is trivial.
    //
    // For the second condition we can use x&(x-1) trick, which removes the last significant bit of binary
    // representation, for example 11010 & 11001 = 11000. Number is power of two if it have only one significant bit,
    // that is after this operation it must be equal to zero.
    //
    // The last part is a bit tricky. Hopefully if reached this step, we already know, that number is a power of 2,
    // so we have not a lot of options left: 1, 10, 100, 1000, ... How we can distinguish one half of them (odd powers)
    // from another half? The trick is to use binary mask m = 1010101010101010101010101010101. For even powers of 2 we
    // have for example m&100 = 100, if we use odd power, for example m&1000 = 0.
    fun isPowerOfFourFaster(num: Int): Boolean {
        return num > 0 && (num and (num - 1)) == 0 && (0b1010101010101010101010101010101 and num) == num
    }
}