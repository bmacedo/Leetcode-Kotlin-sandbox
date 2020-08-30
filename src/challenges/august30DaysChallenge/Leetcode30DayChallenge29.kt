package challenges.august30DaysChallenge


/**
 * Pancake Sorting
 *
 * Given an array of integers A, We need to sort the array performing a series of pancake flips.
 *
 * In one pancake flip we do the following steps:
 * - Choose an integer k where 0 <= k < A.length.
 * - Reverse the sub-array A[0...k].
 *
 * For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2,
 * we reverse the sub-array [3,2,1], so A = [1,2,3,4] after the pancake flip at k = 2.
 *
 * Return an array of the k-values of the pancake flips that should be performed in order to sort A.
 *
 * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 */
fun main(args: Array<String>) {
    println(Leetcode30DayChallenge29.pancakeSort(intArrayOf(3, 2, 4, 1)))
}

object Leetcode30DayChallenge29 {

    fun pancakeSort(A: IntArray): List<Int> {
        fun reverse(lastIndex: Int, A: IntArray) {
            for (i in 0..lastIndex / 2) {
                val temp = A[i]
                A[i] = A[lastIndex - i]
                A[lastIndex - i] = temp
            }
        }

        val result = mutableListOf<Int>()
        var lastIndex = A.lastIndex

        while (lastIndex > 0) {
            var max = Int.MIN_VALUE
            var k = 0
            // Find index of max
            for (i in 0..lastIndex) {
                if (A[i] > max) {
                    max = A[i]
                    k = i
                }
            }

            // Reverse in-place from 0 to indexOfMax
            reverse(k, A)

            // Reverse in-place from 0 to n
            reverse(lastIndex, A)

            // Add reversal indexes to result list
            result.add(k)
            result.add(lastIndex)

            // Assume the last item is the largest and is in the right position
            lastIndex--
        }

        return result
    }
}