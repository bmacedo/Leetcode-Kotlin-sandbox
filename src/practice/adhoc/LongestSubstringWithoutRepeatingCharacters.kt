package practice.adhoc

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
fun main(args: Array<String>) {
//    val input = "abcabcbb" // expect 3
//    val input = "bbbbb"
//    val input = "pwwkew"
    val input = "au"
    println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input))
}

object LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubstring = 0
        when {
            s.isEmpty() -> return 0
            s.length == 1 -> return 1
            else -> {
                var i = 0
                var j = 1
                val tempSubset = HashMap<Char, Int>()
                tempSubset[s[i]] = i
                while (j < s.length) {
                    val char = s[j]
                    if (!tempSubset.contains(char)) {
                        tempSubset[s[j]] = j
                        if (longestSubstring < tempSubset.size) {
                            longestSubstring = tempSubset.size
                        }
                        j++
                    } else {
                        if (longestSubstring < tempSubset.size) {
                            longestSubstring = tempSubset.size
                        }
                        i = tempSubset[char]!! + 1
                        j = i + 1
                        tempSubset.clear()
                        tempSubset[s[i]] = i
                    }
                }
                return longestSubstring
            }
        }
    }

    // Naive solution -- works
//    fun lengthOfLongestSubstring(s: String): Int {
//        var longestSubstring = 0
//        s.forEachIndexed { startIndex, c ->
//            var possibleSubstring = ""
//            for (i in startIndex until s.length) {
//                if (!possibleSubstring.contains(s[i])) possibleSubstring += s[i] else break
//            }
//            if (longestSubstring < possibleSubstring.length) {
//                longestSubstring = possibleSubstring.length
//                println(possibleSubstring)
//            }
//        }
//        return longestSubstring
//    }
}