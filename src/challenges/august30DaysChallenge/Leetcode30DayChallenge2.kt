package challenges.august30DaysChallenge

import challenges.august30DaysChallenge.Leetcode30DayChallenge2.MyHashSet
import kotlin.test.assertFalse
import kotlin.test.assertTrue


/**
 * Design HashSet
 *
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * - add(value): Insert a value into the HashSet
 * - contains(value) : Return whether the value exists in the HashSet or not.
 * - remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 */
fun main(args: Array<String>) {
    val hashSet = MyHashSet()
    hashSet.add(1)
    hashSet.add(2)
    assertTrue { hashSet.contains(1) }    // returns true
    assertFalse { hashSet.contains(3) }    // returns false (not found)
    hashSet.add(2)
    assertTrue { hashSet.contains(2) }    // returns true
    hashSet.remove(2)
    assertFalse { hashSet.contains(2) }    // returns false (already removed)
}

object Leetcode30DayChallenge2 {

    class MyHashSet {

        private val list = mutableListOf<Boolean>()

        fun add(key: Int) {
            if (list.size <= key) {
                val additionalItems = key - list.size
                for (i in 0..additionalItems) {
                    list.add(false)
                }
            }

            list[key] = true
        }

        fun remove(key: Int) {
            if (list.size > key) {
                list[key] = false
            }
        }

        /** Returns true if this set contains the specified element */
        fun contains(key: Int): Boolean {
            if (list.size > key) {
                return list[key]
            }
            return false
        }
    }
}