package challenges.may30DaysChallenge

/**
 * Maximum Sum Circular Subarray
 *
 * Given a circular array C of integers represented by A, find the maximum possible
 * sum of a non-empty subarray of C.
 *
 * Here, a circular array means the end of the array connects to the beginning of the
 * array.
 *
 * Formally, C[ i ] = A[ i ] when 0 <= i < A.length, and C[i+A.length] = C[ i ] when i >= 0.
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.
 *
 * Formally, for a subarray C[ i ], C[i+1], ..., C[ j ], there does not exist i <= k1, k2 <= j
 * with k1 % A.length = k2 % A.length.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(5,-3,5)
    println(Leetcode30DayChallenge15.maxSubarraySumCircular(input))
}

object Leetcode30DayChallenge15 {

    fun maxSubarraySumCircular(A: IntArray): Int {
        var previousMaxSum = 0
        var previousMaxInvertedSum = 0
        var maxSum = Int.MIN_VALUE
        var maxInvertedSum = Int.MIN_VALUE
        var total = 0
        A.forEach { num ->
            // calculate total
            total += num

            // calculate max subarray using normal kadane's algo
            val sum = Math.max(previousMaxSum + num, num)
            previousMaxSum = sum
            if (sum > maxSum) maxSum = sum

            // calculate max subarray using kadane's algo on array with elements inverted
            val invertedSum = Math.max(previousMaxInvertedSum - num, -num)
            previousMaxInvertedSum = invertedSum
            if (invertedSum > maxInvertedSum) maxInvertedSum = invertedSum
        }
        // If all elements of the array were negative, maxSum will be less than zero
        // So we need to check that case.
        return if (maxSum > 0) Math.max(maxSum, total + maxInvertedSum) else maxSum
    }
}


