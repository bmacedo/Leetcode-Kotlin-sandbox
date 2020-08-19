package challenges.august30DaysChallenge

import kotlin.test.assertEquals


/**
 * Goat Latin
 *
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * -If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word
 * For example, the word 'apple' becomes 'applema'.
 *
 * -If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * -Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 *
 * Return the final sentence representing the conversion from S to Goat Latin.
 */
fun main(args: Array<String>) {
    assertEquals(
            "Imaa peaksmaaa oatGmaaaa atinLmaaaaa",
            Leetcode30DayChallenge19.toGoatLatin("I speak Goat Latin")
    )
    assertEquals(
            "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
            Leetcode30DayChallenge19.toGoatLatin("The quick brown fox jumped over the lazy dog")
    )
    println("Success")
}

object Leetcode30DayChallenge19 {

    fun toGoatLatin(S: String): String {
        val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')
        return S.split(" ").mapIndexed { index, s ->
            var result = s
            if (!vowels.contains(s.first().toLowerCase())) {
                result = s.substring(1) + s.first()
            }
            result += "ma" + "a".repeat(index + 1)
            result
        }.joinToString(" ")
    }
}