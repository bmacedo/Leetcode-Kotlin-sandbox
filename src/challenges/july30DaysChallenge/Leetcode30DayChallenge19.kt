package challenges.july30DaysChallenge


/**
 * Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 */
fun main(args: Array<String>) {
    val a = "11"
    val b = "1"
    println(Leetcode30DayChallenge19.addBinary(a, b))
}


object Leetcode30DayChallenge19 {

    fun addBinary(a: String, b: String): String {
        val maxLength = maxOf(a.length, b.length)
        val A = a.padStart(maxLength, '0')
        val B = b.padStart(maxLength, '0')

        var result = StringBuilder()
        var carryOver = 0
        for (i in A.lastIndex downTo 0) {
            val aInt = if (A[i] == '0') 0 else 1
            val bInt = if (B[i] == '0') 0 else 1
            val sum = carryOver + aInt + bInt
            val value = sum % 2
            carryOver = if (sum > 1) 1 else 0
            result = result.append(value)
        }
        if (carryOver == 1) result.append(1)
        return result.reversed().toString()
    }
}
