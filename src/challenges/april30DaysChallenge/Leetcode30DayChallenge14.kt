package challenges.april30DaysChallenge


/**
 * You are given a string s containing lowercase English letters, and a matrix shift,
 * where shift(i) = [direction, amount]:
 *
 * -    direction can be 0 (for left shift) or 1 (for right shift).
 * -    amount is the amount by which string s is to be shifted.
 * -    A left shift by 1 means remove the first character of s and append it to the end.
 * -    Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 *
 * Return the final string after all operations.
 */
fun main(args: Array<String>) {
    val input = "abcdefg"
    val shift = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(0, 2), intArrayOf(1, 3))
    println(Leetcode30DayChallenge14.stringShift(input, shift)) // expect "efgabcd"
}

object Leetcode30DayChallenge14 {

    fun stringShift(s: String, shift: Array<IntArray>): String {
        var shiftCount = 0
        shift.forEach { arr ->
            val direction = if (arr[0] == 0) 1 else -1
            val amount = arr[1]
            shiftCount += (amount * direction)
        }
        val stringBuilder = StringBuilder()
        for (i in s.indices) {
            val j = Math.floorMod(shiftCount + i, s.length)
            stringBuilder.append(s[j])
        }
        return stringBuilder.toString()
    }
}
