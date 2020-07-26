package challenges.july30DaysChallenge


/**
 * Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 */
fun main(args: Array<String>) {
    val input = 38

    println(Leetcode30DayChallenge26.addDigits(input))
}


object Leetcode30DayChallenge26 {


    // Congruence formula: https://en.wikipedia.org/wiki/Digital_root
    // O(1) time
    fun addDigits(num: Int): Int {
        if (num == 0) return 0
        return 1 + ((num - 1) % 9)
    }

    // O(n) time
    fun addDigitsLoop(num: Int): Int {
        var result = num
        while (result > 9) {
            var subResult = result
            var sum = 0
            while (subResult != 0) {
                sum += subResult % 10
                subResult /= 10
            }
            println(sum)
            result = sum
        }
        return result
    }
}
