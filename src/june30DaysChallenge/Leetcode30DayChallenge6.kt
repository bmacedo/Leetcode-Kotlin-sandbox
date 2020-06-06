package june30DaysChallenge

import utils.print
import java.util.*

/**
 * Queue Reconstruction by Height
 *
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height greater than or equal to h.
 *
 * Write an algorithm to reconstruct the queue.
 *
 * Note: The number of people is less than 1,100.
 */
fun main(args: Array<String>) {
    val input = arrayOf(
            intArrayOf(7, 0),
            intArrayOf(4, 4),
            intArrayOf(7, 1),
            intArrayOf(5, 0),
            intArrayOf(6, 1),
            intArrayOf(5, 2)
    )
    Leetcode30DayChallenge6.reconstructQueue(input).print()
}

object Leetcode30DayChallenge6 {

    // O(n2)
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val result = LinkedList<IntArray>()
        people.sortWith(compareBy({ person -> -person[0] }, { person -> person[1] }))
        // possibly O(n2)
        people.forEach { person -> result.add(person[1], person) }
        return result.toTypedArray()
    }

    // O(n2)
    fun reconstructQueueSlow(people: Array<IntArray>): Array<IntArray> {
        if (people.isEmpty()) return people

        val output = arrayOfNulls<IntArray>(people.size)

        // O(nlogn)
        val priorityQueue = PriorityQueue<IntArray>(people.size) { (x, y), (x2, y2) ->
            x.compareTo(x2).takeUnless { it == 0 } ?: y.compareTo(y2)
        }
        priorityQueue.addAll(people)
        // O(n2)
        while (priorityQueue.isNotEmpty()) {
            val (x, y) = priorityQueue.poll()
            var i = 0
            var count = y
            while (i < output.size) {
                if (output[i] == null || output[i]!![0] >= x) count--
                if (count < 0 && output[i] == null) {
                    output[i] = intArrayOf(x, y)
                    break
                }
                i++
            }
        }
        return output.requireNoNulls()
    }

}