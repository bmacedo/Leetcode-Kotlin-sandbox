package challenges.april30DaysChallenge

import kotlin.test.assertEquals


/**
 * First Unique Number
 *
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 * -    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * -    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * -    void add(int value) insert value to the queue.
 */
fun main(args: Array<String>) {
    val firstUnique = FirstUnique(intArrayOf(2,3,5))
    assertEquals(2, firstUnique.showFirstUnique())
    firstUnique.add(5)           // the queue is now [2,3,5,5]
    assertEquals(2, firstUnique.showFirstUnique())
    firstUnique.add(2)            // the queue is now [2,3,5,5,2]
    assertEquals(3, firstUnique.showFirstUnique())
    firstUnique.add(3)            // the queue is now [2,3,5,5,2,3]
    assertEquals(-1, firstUnique.showFirstUnique())
    firstUnique.add(3)            // the queue is now [2,3,5,5,2,3]
    assertEquals(-1, firstUnique.showFirstUnique())
}

class FirstUnique(nums: IntArray) {

    private val repeatedItems = HashSet<Int>()
    private val uniqueItems = LinkedHashSet<Int>()

    init {
        nums.forEach { add(it) }
    }

    fun showFirstUnique(): Int = uniqueItems.firstOrNull() ?: -1

    fun add(value: Int) {
        if (!repeatedItems.contains(value) && !uniqueItems.contains(value)) {
            uniqueItems.add(value)
        } else {
            if (uniqueItems.contains(value)) {
                uniqueItems.remove(value)
                repeatedItems.add(value)
            }
        }
    }

}
