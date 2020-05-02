package biweeklyContest25

/**
 * Max Difference You Can Get From Changing an Integer
 *
 * You are given an integer num. You will apply the following steps exactly two times:
 *
 * -    Pick a digit x (0 <= x <= 9).
 * -    Pick another digit y (0 <= y <= 9). The digit y can be equal to x
 * -    Replace all the occurrences of x in the decimal representation of num by y.
 * -    The new integer cannot have any leading zeros, also the new integer cannot be 0.
 *
 * Let a and b be the results of applying the operations to num the first and second times, respectively.
 *
 * Return the max difference between a and b.
 */
fun main(args: Array<String>) {
    val num = 9288
    println(MaxDifferenceYouCanGetFromChangingInteger.maxDiff(num))
}

object MaxDifferenceYouCanGetFromChangingInteger {

    fun maxDiff(num: Int): Int {
        var biggest = 0
        for (i in 0..9) {
            for (j in 0..9) {
                val biggestStr = num.toString().replace("$i"[0], "$j"[0])
                if (!biggestStr.startsWith('0') && biggestStr.toInt() > biggest && biggestStr.toInt() != 0) {
                    biggest = biggestStr.toInt()
                }
            }
        }

        var lowest = Int.MAX_VALUE
        for (i in 0..9) {
            for (j in 0..9) {
                val lowestStr = num.toString().replace("$i"[0], "$j"[0])
                if (!lowestStr.startsWith('0') && lowestStr.toInt() < lowest && lowestStr.toInt() != 0) {
                    lowest = lowestStr.toInt()
                }
            }
        }
        return biggest - lowest
    }
}