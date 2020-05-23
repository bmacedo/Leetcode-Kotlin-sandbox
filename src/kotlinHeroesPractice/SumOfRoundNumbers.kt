package kotlinHeroesPractice

/**
 * Sum of Round Numbers
 *
 * A positive (strictly greater than zero) integer is called round if it is of the form d00...0.
 * In other words, a positive integer is round if all its digits except the leftmost (most significant)
 * are equal to zero. In particular, all numbers from 1 to 9 (inclusive) are round.
 *
 * For example, the following numbers are round: 4000, 1, 9, 800, 90.
 * The following numbers are not round: 110, 707, 222, 1001
 */
fun main(args: Array<String>) {
    val n = readLine()!!.toInt() // read integer from the input
    repeat(n) {
        val x = readLine()!!.toInt()
        SumOfRoundNumbers.factor(x)
    }
}

object SumOfRoundNumbers {
    fun factor(x: Int) {
        val res = x.toString()
        val n = res.length
        val ans = StringBuilder()
        var count = 0
        res.toCharArray().forEachIndexed { index, digit ->
            val numberOfZeros = n - 1 - index
            if (digit != '0') {
                count++
                ans.append(digit)
                ans.append("0".repeat(numberOfZeros))
                ans.append(" ")
            }
        }
        println(count)
        println(ans.toString().trim())
    }
}
