package contests.biweeklyContest27

/**
 * Check If a String Contains All Binary Codes of Size K
 *
 * Given a binary string s and an integer k.
 *
 * Return True if any binary code of length k is a substring of s. Otherwise, return False.
 */
fun main(args: Array<String>) {
    val s = "00110"
    val k = 2
    println(CheckIfStringContainsAllBinaryCodesSizeK.hasAllCodes(s, k))
}

object CheckIfStringContainsAllBinaryCodesSizeK {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val hash = HashSet<String>()

        var start = 0
        var end = start + k
        while (end <= s.length) {
            hash.add(s.substring(start, end))
            start++
            end = start + k
        }

        val upperBound = 1 shl k
        var num = upperBound - 1
        while (num >= 0) {
            val numStr = Integer.toBinaryString(num)
            val paddingSize = k - numStr.length
            val paddedStr = if (paddingSize > 0) "0".repeat(paddingSize) + numStr else numStr
            if (!hash.contains(paddedStr)) return false
            num--
        }
        return true
    }
}