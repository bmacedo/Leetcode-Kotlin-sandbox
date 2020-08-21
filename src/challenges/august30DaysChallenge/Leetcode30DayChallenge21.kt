package challenges.august30DaysChallenge


/**
 * Sort Array By Parity
 *
 * Given an array A of non-negative integers, return an array consisting of all the even
 * elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 */
fun main(args: Array<String>) {
    println(Leetcode30DayChallenge21.sortArrayByParity(intArrayOf(3, 1, 2, 4)).toList())
}

object Leetcode30DayChallenge21 {


    // O(n) time, O(1) space
    fun sortArrayByParity(A: IntArray): IntArray {
        var i = 0
        for (x in 0 until A.size) {
            if (A[x] % 2 == 0) {
                val temp = A[i]
                A[i] = A[x]
                A[x] = temp
                i++
            }
        }
        return A
    }

    // O(n log n) time, O(n) space
    fun sortArrayByParitySlow(A: IntArray): IntArray {
        return A.sortedWith(kotlin.Comparator { o1, o2 ->
            when {
                o1 % 2 == 0 && o2 % 2 != 0 -> -1
                o1 % 2 != 0 && o2 % 2 == 0 -> 1
                else -> o1.compareTo(o2)
            }
        }).toIntArray()
    }
}