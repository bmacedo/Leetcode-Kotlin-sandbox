package challenges.august30DaysChallenge

/**
 * Detect Capital
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * - All letters in this word are capitals, like "USA".
 * - All letters in this word are not capitals, like "leetcode".
 * - Only the first letter in this word is capital, like "Google".
 *
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
fun main(args: Array<String>) {
    val input = "fff"
    println(Leetcode30DayChallenge1.detectCapitalUse(input))
}

object Leetcode30DayChallenge1 {

    fun detectCapitalUse(word: String): Boolean {
        var canBeAllUpperCase = true
        var canBeAllLowerCase = true
        var canBeOnlyFirstUpperCase = true

        for (i in word.indices) {
            val char = word[i]
            if (char.isUpperCase()) {
                canBeAllLowerCase = false
                canBeOnlyFirstUpperCase = i == 0
            } else {
                canBeAllUpperCase = false
                canBeOnlyFirstUpperCase = canBeOnlyFirstUpperCase && i > 0
            }

            val shouldContinue = canBeAllLowerCase || canBeAllUpperCase || canBeOnlyFirstUpperCase
            if (!shouldContinue) return false
        }

        return true
    }
}