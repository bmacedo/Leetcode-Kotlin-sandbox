package challenges.august30DaysChallenge

import challenges.august30DaysChallenge.Leetcode30DayChallenge13.CombinationIterator
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Iterator for Combination
 *
 * Design an Iterator class, which has:
 *
 * - A constructor that takes a string characters of sorted distinct lowercase English letters and
 * a number combinationLength as arguments.
 *
 * - A function next() that returns the next combination of length combinationLength in lexicographical order.
 *
 * - A function hasNext() that returns True if and only if there exists a next combination.
 */
fun main(args: Array<String>) {
    val iterator = CombinationIterator("abc", 2)
    assertEquals("ab", iterator.next())
    assertTrue(iterator.hasNext())
    assertEquals("ac", iterator.next())
    assertTrue(iterator.hasNext())
    assertEquals("bc", iterator.next())
    assertFalse(iterator.hasNext())
}

object Leetcode30DayChallenge13 {

    class CombinationIterator(characters: String, private val combinationLength: Int) {

        var queue: Queue<String> = LinkedList()

        init {
            combinations(characters, 0, "", combinationLength, queue)
        }

        private fun combinations(characters: String, start: Int, soFar: String, k: Int, queue: Queue<String>) {
            if (k == 0) {
                queue.add(soFar)
                return
            }

            for (i in start until characters.length) {
                combinations(characters, i + 1, soFar + characters[i], k - 1, queue)
            }
        }

        operator fun next(): String = queue.poll()

        operator fun hasNext(): Boolean = !queue.isEmpty()

    }
}