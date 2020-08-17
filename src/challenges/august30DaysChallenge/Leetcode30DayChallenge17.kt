package challenges.august30DaysChallenge

import kotlin.test.assertEquals

/**
 * Distribute Candies to People
 *
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 *
 * - We then give 1 candy to the first person, 2 candies to the second person, and so on until we give
 * n candies to the last person.
 *
 * - Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies
 * to the second person, and so on until we give 2 * n candies to the last person.
 *
 * - This process repeats (with us giving one more candy each time, and moving to the start of the row
 * after we reach the end) until we run out of candies.
 *
 * - The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
 *
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 */
fun main(args: Array<String>) {
    assertEquals(intArrayOf(1, 2, 3, 1).toList(), Leetcode30DayChallenge17.distributeCandies(7, 4).toList())
    assertEquals(intArrayOf(5, 2, 3).toList(), Leetcode30DayChallenge17.distributeCandies(10, 3).toList())
    println("Success")
}

object Leetcode30DayChallenge17 {

    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        var totalCandiesToDistribute = candies
        var nextCandiesBatch = 1
        var i = 0
        val result = IntArray(num_people)
        while (nextCandiesBatch <= totalCandiesToDistribute) {
            val index = i % num_people
            result[index] += nextCandiesBatch
            totalCandiesToDistribute -= nextCandiesBatch
            nextCandiesBatch++
            i++
        }
        val index = i % num_people
        result[index] += totalCandiesToDistribute
        return result
    }
}