package challenges.may30DaysChallenge

/**
 * First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
fun main(args: Array<String>) {
    val input = "loveleetcode" // expect 2
    println(Leetcode30DayChallenge5.firstUniqChar(input))
}

object Leetcode30DayChallenge5 {

    fun firstUniqChar(s: String): Int {
        val hash = IntArray(26) { -1 }

        s.forEachIndexed { index, char ->
            val position = char - 'a'
            hash[position] = if (hash[position] != -1) -2 else index
        }
        return hash.filter { it >= 0 }.min() ?: -1
    }
}


