package arrays101

/**
 * Sort Array By Parity
 *
 * Given an array A of non-negative integers, return an array consisting of all the even
 * elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(3,1,2,4)
    print(SortArrayByParity.sortArrayByParity(input).toList())
}

object SortArrayByParity {
    fun sortArrayByParity(A: IntArray): IntArray {
        var slow = 0
        var cur = 0
        while (cur < A.size) {
            while (cur < A.size && A[cur] % 2 != 0) cur++
            if (cur < A.size && A[cur] % 2 == 0) {
                val temp = A[slow]
                A[slow] = A[cur]
                A[cur] = temp
                slow++
            }
            cur++
        }
        return A
    }
}