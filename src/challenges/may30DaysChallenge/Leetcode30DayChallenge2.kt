package challenges.may30DaysChallenge

/**
 * Jewels and Stones
 *
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.
 * Each character in S is a type of stone you have.
 *
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 */
fun main(args: Array<String>) {
    val J = "z"
    val S = "ZZ"
    println(Leetcode30DayChallenge2.numJewelsInStones(J, S))
}

object Leetcode30DayChallenge2 {

    fun numJewelsInStones(J: String, S: String): Int {
        val jewelSet = HashSet<Char>()
        J.forEach { jewelSet.add(it) }

        var count = 0
        S.forEach { if (jewelSet.contains(it)) count++ }
        return count
    }
}


