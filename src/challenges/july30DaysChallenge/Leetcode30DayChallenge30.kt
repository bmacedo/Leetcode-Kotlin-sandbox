package challenges.july30DaysChallenge


/**
 * Word Break II
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * Note:
 * - The same word in the dictionary may be reused multiple times in the segmentation.
 * - You may assume the dictionary does not contain duplicate words.
 */
fun main(args: Array<String>) {
    val s = "catsanddog"
    val wordDict = arrayListOf("cat", "cats", "and", "sand", "dog")
    println(Leetcode30DayChallenge30.wordBreak(s, wordDict))
}


object Leetcode30DayChallenge30 {

    fun wordBreak(s: String, wordDict: List<String>, memo: HashMap<String, List<String>> = HashMap()): List<String> {
        if (memo.containsKey(s)) return memo[s]!!

        val res = mutableListOf<String>()
        if (s.isEmpty()) {
            res.add("")
            return res
        }
        for (word in wordDict) {
            if (s.startsWith(word)) {
                val str = s.substring(word.length)
                val subStrings = wordBreak(str, wordDict, memo)
                for (substring in subStrings) {
                    val optionalSpace = if (substring.isEmpty()) "" else " "
                    res.add(word + optionalSpace + substring)
                }
            }
        }
        memo[s] = res
        return res
    }
}
