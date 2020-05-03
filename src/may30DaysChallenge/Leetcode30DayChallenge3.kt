package may30DaysChallenge

/**
 * Ransom Note
 *
 * Given an arbitrary ransom note string and another string containing letters from
 * all the magazines, write a function that will return true if the ransom note can
 * be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 */
fun main(args: Array<String>) {
    val ransomNote = "a"
    val magazine = "ab"
    println(Leetcode30DayChallenge3.canConstruct(ransomNote, magazine))
}

object Leetcode30DayChallenge3 {

    // O(n+m) optimized
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val cnt = IntArray(26)
        val a = 'a'.toInt()
        for (char in magazine.toCharArray())
            ++cnt[char.toInt() - a]
        for (char in ransomNote.toCharArray())
            if (--cnt[char.toInt() - a] < 0) return false
        return true
    }

    // O(n+m)
    fun canConstructFast(ransomNote: String, magazine: String): Boolean {
        val hash = HashMap<Char, Int>() // <Char, Count>

        magazine.forEach { char -> hash[char] = hash.getOrDefault(char, 0) + 1 }
        ransomNote.forEach { char ->
            val count = hash.getOrDefault(char, 0) - 1
            if (count < 0) return false
            hash[char] = count
        }
        return true
    }

    // O(nlogn)
    fun canConstructSlow(ransomNote: String, magazine: String): Boolean {
        // O(nlogn)
        val sortedNote = ransomNote.toCharArray().sorted()
        val sortedMagazine = magazine.toCharArray().sorted()

        // O(n+m)
        var j = 0
        for (i in sortedNote.indices) {
            while (j in sortedMagazine.indices && sortedNote[i] != sortedMagazine[j]) {
                j++
            }
            if (j >= sortedMagazine.size && i < sortedNote.size) return false
            j++
        }
        return true
    }
}


