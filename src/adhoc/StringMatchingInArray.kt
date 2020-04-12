package adhoc

/**
 * Given an array of string words.
 * Return all strings in words which is substring of another word in any order.
 *
 * String words[i] is substring of words[j], if can be obtained removing some
 * characters to left and/or right side of words[j].
 */
fun main(args: Array<String>) {
    val input = arrayOf("leetcoder","leetcode","od","hamlet","am")
    println(StringMatchingInArray.stringMatching(input))

}

object StringMatchingInArray {

    fun stringMatching(words: Array<String>): List<String> {
        val matchingStr = mutableSetOf<String>()
        words.forEachIndexed { i, currentWord ->
            words.forEachIndexed { j, str ->
                if (i != j && currentWord.contains(str)) {
                    matchingStr.add(str)
                }
            }
        }
        return matchingStr.toList()
    }
}