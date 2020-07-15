package easyTopInterviewQuestions

/**
 * Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and return the number of '1' bits it has
 * (also known as the Hamming weight).
 */
fun main(args: Array<String>) {
    val input = 11
    println(NumberOf1Bits.hammingWeight(input))
}

object NumberOf1Bits {

    fun hammingWeight(n: Int): Int {
        var count = 0
        for (i in 0 until 32) {
            val bit = (n ushr i) and 1
            if (bit == 1) count++
        }
        return count
    }
}