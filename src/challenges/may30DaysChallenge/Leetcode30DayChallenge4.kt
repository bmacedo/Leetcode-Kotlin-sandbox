package challenges.may30DaysChallenge

/**
 * Number Complement
 *
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 */
fun main(args: Array<String>) {
    val input = 5 // expect: 2
    println(Leetcode30DayChallenge4.findComplement(input))
}

object Leetcode30DayChallenge4 {

    fun findComplement(num: Int): Int {
        val highestBit = Integer.toBinaryString(num).reversed().indexOfLast { it == '1' }
        val numberOfPositionsToShift = 32 - highestBit
        val shiftedLeft = num shl (numberOfPositionsToShift)
        val inverted = shiftedLeft.inv()
        return if (numberOfPositionsToShift == 32) 0 else inverted ushr numberOfPositionsToShift
    }
}


