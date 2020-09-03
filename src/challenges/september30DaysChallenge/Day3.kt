package challenges.september30DaysChallenge


/**
 * Repeated Substring Pattern
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending
 * multiple copies of the substring together.
 *
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 */
fun main(args: Array<String>) {
    println(Day3.repeatedSubstringPattern("abcabcabc"))
}

object Day3 {

    /*
    If we can form the string s with repeated pattern m =>
    s = m + m + ... + m + m(n times)
    s + s = m + m + ... + m + m(2n times)
    Now if we remove first and last character from s + s which even after that we should
    have 2n - 2 consecutive m so which measn we can check for s in 2s.

    s + s substirng(1, 2n-2) ==> m1 + m + m + ..... + m +m + m2
     */
    fun repeatedSubstringPattern(s: String): Boolean {
        return (s + s).substring(1, 2 * s.length - 1).contains(s)
    }
}