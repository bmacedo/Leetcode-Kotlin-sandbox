package challenges.september30DaysChallenge


/**
 * Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 */
fun main(args: Array<String>) {
    println(Day7.wordPattern("abc", "dog cat fish"))
}

object Day7 {

    // O(n) time, O(n) space
    fun wordPattern(pattern: String, str: String): Boolean {
        val words = str.split(" ")
        if (pattern.length != words.size) return false

        val map = HashMap<Char, String>() // Char, Word
        val inverseMap = HashMap<String, Char>() // Word, Char

        for (i in words.indices) {
            val word = words[i]
            val char = pattern[i]

            if (map[char] != null || inverseMap[word] != null) {
                if (map[char] != word || inverseMap[word] != char) return false
            } else {
                map[char] = word
                inverseMap[word] = char
            }
        }
        return true
    }
}


