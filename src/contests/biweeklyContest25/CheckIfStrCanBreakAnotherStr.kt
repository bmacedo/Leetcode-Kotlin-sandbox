package contests.biweeklyContest25

/**
 * Check If a String Can Break Another String
 *
 * Given two strings: s1 and s2 with the same size, check if some permutation of string s1
 * can break some permutation of string s2 or vice-versa (in other words s2 can break s1).
 *
 * A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for
 * all i between 0 and n-1.
 *
 */
fun main(args: Array<String>) {
    val s1 = "abc"
    val s2 = "xya"
    println(CheckIfStrCanBreakAnotherStr.checkIfCanBreak(s1, s2))
}

object CheckIfStrCanBreakAnotherStr {

    fun checkIfCanBreak(s1: String, s2: String): Boolean {
        val s1Sorted = s1.toCharArray().sorted()
        val s2Sorted = s2.toCharArray().sorted()

        var s1BreakS2 = 0
        var s2BreakS1 = 0
        for (i in s1.indices) {
            if (s1Sorted[i] <= s2Sorted[i]) s2BreakS1++
            if (s1Sorted[i] >= s2Sorted[i]) s1BreakS2++
        }
        return Math.max(s1BreakS2, s2BreakS1) == s1.length
    }
}