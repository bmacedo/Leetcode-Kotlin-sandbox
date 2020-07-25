package challenges.june30DaysChallenge

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects
 * of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 */
fun main(args: Array<String>) {
    val randomSet = Leetcode30DayChallenge12.RandomizedSet()
    assertTrue { randomSet.insert(1) }
    assertFalse { randomSet.remove(2) }
    assertTrue { randomSet.insert(2) }
    val randomVal = randomSet.getRandom()
    assert(randomVal == 1 || randomVal == 2)
    assertTrue { randomSet.remove(1) }
    assertFalse { randomSet.insert(2) }
    assert(randomSet.getRandom() == 2)
}

object Leetcode30DayChallenge12 {

    class RandomizedSet {

        /** Initialize your data structure here. */
        val set = mutableSetOf<Int>()

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        fun insert(`val`: Int): Boolean {
            return set.add(`val`)
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        fun remove(`val`: Int): Boolean {
            return set.remove(`val`)
        }

        /** Get a random element from the set. */
        fun getRandom(): Int {
            val randomIndex = (set.size * Math.random()).toInt()
            return set.elementAt(randomIndex)
        }

    }
}