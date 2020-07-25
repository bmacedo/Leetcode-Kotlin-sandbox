package challenges.may30DaysChallenge

import java.util.*
import kotlin.collections.LinkedHashMap


/**
 * Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
fun main(args: Array<String>) {
    val input = "Aabb"

    println(Leetcode30DayChallenge22.frequencySort(input))
}

object Leetcode30DayChallenge22 {

    // this one should be slower than the other approach, because of the sorting
    // but leetcode indicates that it actually runs faster. Might be because of the
    // tests they use.
    fun frequencySort(s: String): String {
        val hash = HashMap<Char, Int>()
        // O(n)
        s.toCharArray().forEach { hash[it] = hash.getOrDefault(it, 0) + 1 }

        val strBuilder = StringBuilder()

        // O(n log n)
        hash.toList().sortedByDescending { it.second }.forEach { (char, times) ->
            repeat(times) { strBuilder.append(char) }
        }
        return strBuilder.toString()
    }

    fun frequencySortDoubleMemory(s: String): String {
        val hash = HashMap<Char, Int>()
        val frequencyHash = LinkedHashMap<Int, HashSet<Char>>()

        // O(n)
        s.toCharArray().forEach { char ->
            val currentValue = hash.getOrDefault(char, 0)
            if (currentValue > 0) {
                frequencyHash[currentValue]?.remove(char)
            }
            hash[char] = currentValue + 1
            frequencyHash[currentValue + 1] = frequencyHash.getOrDefault(currentValue + 1, HashSet())
                    .apply { add(char) }
        }

        val strBuilder = StringBuilder()

        // O(n)
        frequencyHash.keys.reversed().forEach { repeatTimes ->
            val chars = frequencyHash[repeatTimes]
            chars?.forEach { char -> repeat(repeatTimes) { strBuilder.append(char) } }
        }
        return strBuilder.toString()
    }
}

