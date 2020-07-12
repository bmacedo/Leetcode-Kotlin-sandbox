package july30DaysChallenge


/**
 * Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 */
fun main(args: Array<String>) {
    val input = "00000010100101000001111010011100".toInt(2)
    println(Integer.toBinaryString(Leetcode30DayChallenge12.reverseBits(input)).padStart(32, '0'))
}

object Leetcode30DayChallenge12 {

    fun reverseBits(n: Int): Int {
        var result = 0
        for (i in 0 until 32) {
            val ithBit = (n ushr i) and 1
            val reversedIthBit = ithBit shl (31 - i)
            result = result or reversedIthBit
        }
        return result
    }
}
