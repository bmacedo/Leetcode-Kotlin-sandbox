package practice.arrays101

/**
 * Valid Mountain Array
 *
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 *
 * Recall that A is a mountain array if and only if:
 * -    A.length >= 3
 * -    There exists some i with 0 < i < A.length - 1 such that:
 *      - A[0] < A[1] < ... A[i-1] < A[i]
 *      - A[i] > A[i+1] > ... > A[A.length - 1]
 */
fun main(args: Array<String>) {
    val input = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    println(ValidMountainArray.validMountainArray(input))
}

object ValidMountainArray {
    fun validMountainArray(A: IntArray): Boolean {
        val n = A.size.takeIf { it >= 3 } ?: return false
        var increasing = if (A[0] < A[1]) true else return false
        var i = 0
        while (i < n - 1 && increasing) {
            i++
            if (A[i - 1] >= A[i]) {
                increasing = false
                break
            }
        }
        if (increasing) return false
        while (i < n) {
            if (A[i - 1] <= A[i]) return false
            i++
        }
        return true
    }
}