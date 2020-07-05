package july30DaysChallenge

/**
 * Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 */
fun main(args: Array<String>) {
    val x = 1
    val y = 4
    println(Leetcode30DayChallenge5.hammingDistance(x, y))
}

object Leetcode30DayChallenge5 {

    fun hammingDistance(x: Int, y: Int): Int {
        var distance = 0
        for (i in 0 until 32) {
            val lastBitX = (x ushr i) and 1
            val lastBitY = (y ushr i) and 1
            if (lastBitX != lastBitY) distance++
        }
        return distance
    }

}
