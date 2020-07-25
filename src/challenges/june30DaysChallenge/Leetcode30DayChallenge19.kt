package challenges.june30DaysChallenge

import java.util.*


/**
 * Longest Duplicate Substring
 *
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or
 * more times.  (The occurrences may overlap.)
 *
 * Return any duplicated substring that has the longest possible length.
 * (If S does not have a duplicated substring, the answer is "".)
 */
fun main(args: Array<String>) {
    val input = "banana"
    println(Leetcode30DayChallenge19.longestDupSubstring(input))
}

object Leetcode30DayChallenge19 {

    // O(n log n)
    fun longestDupSubstring(S: String): String {
        // Rabin-Karp search algorithm
        fun search(L: Int, a: Int, modulus: Long, n: Int, nums: IntArray): Int {
            // compute the hash of string S[:L]
            var h: Long = 0
            for (i in 0 until L) h = (h * a + nums[i]) % modulus

            // already seen hashes of strings of length L
            val seen = HashSet<Long?>()
            seen.add(h)
            // const value to be used often : a**L % modulus
            var aL: Long = 1
            for (i in 1..L) aL = aL * a % modulus
            for (start in 1 until n - L + 1) {
                // compute rolling hash in O(1) time
                h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus
                h = (h + nums[start + L - 1]) % modulus
                if (seen.contains(h)) return start
                seen.add(h)
            }
            return -1
        }

        // Use Binary search + Rabin-Karp algorithm
        val n: Int = S.length
        // convert string to array of integers
        // to implement constant time slice
        // convert string to array of integers
        // to implement constant time slice
        val nums = IntArray(n)
        for (i in 0 until n) nums[i] = S[i].toInt() - 'a'.toInt()
        // base value for the rolling hash function
        // base value for the rolling hash function
        val a = 26
        // modulus value for the rolling hash function to avoid overflow
        // modulus value for the rolling hash function to avoid overflow
        val modulus = Math.pow(2.0, 32.0).toLong()

        // binary search, L = repeating string length

        // binary search, L = repeating string length
        var left = 1
        var right = n
        var L: Int
        while (left != right) {
            L = left + (right - left) / 2
            if (search(L, a, modulus, n, nums) != -1) left = L + 1 else right = L
        }

        val start = search(left - 1, a, modulus, n, nums)
        return if (start != -1) S.substring(start, start + left - 1) else ""
    }


    // O(n square)
    fun longestDupSubstringSlow(string: String): String {
        val hashtable = Hashtable<String, Int>()
        val length: Int = string.length
        for (subLength in length - 1 downTo 2) {
            for (i in 0..length - subLength) {
                val sub: String = string.substring(i, subLength + i)
                if (hashtable.containsKey(sub)) {
                    return sub
                } else {
                    hashtable[sub] = subLength
                }
            }
        }
        return ""
    }

}