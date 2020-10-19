package challenges.october30DaysChallenge

/**
 * Minimum Domino Rotations For Equal Row
 *
 * In a row of dominoes, A[ i ] and B[ i ] represent the top and bottom halves of the ith domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that A[ i ] and B[ i ] swap values.
 *
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 * If it cannot be done, return -1.
 */
fun main(args: Array<String>) {
    val A = intArrayOf(2, 1, 1, 1, 2, 1)
    val B = intArrayOf(1, 2, 1, 2, 1, 2)
    println(Day19.minDominoRotations(A, B))
}

object Day19 {

    fun minDominoRotations(A: IntArray, B: IntArray): Int {
        if (A.isEmpty() || B.isEmpty() || A.size != B.size) return -1

        val withoutRotatingFirst = calcRotations(A[0], B[0], A, B)
        val rotatingFirst = calcRotations(B[0], A[0], A, B) + 1

        return when {
            withoutRotatingFirst > -1 && rotatingFirst > 0 -> minOf(withoutRotatingFirst, rotatingFirst)
            rotatingFirst > 0 -> rotatingFirst
            else -> withoutRotatingFirst
        }
    }

    private fun calcRotations(candidate1: Int, candidate2: Int, A: IntArray, B: IntArray): Int {
        val possibleCandidates = mutableListOf(A[0], B[0])
        var count1 = 0
        var count2 = 0

        for (i in 1 until A.size) {
            if (candidate1 != A[i] && candidate1 != B[i]) possibleCandidates.remove(candidate1)
            if (candidate2 != A[i] && candidate2 != B[i]) possibleCandidates.remove(candidate2)
            if (possibleCandidates.isEmpty()) return -1

            if (candidate1 == B[i] && candidate1 != A[i]) {
                count2++
            }
            if (candidate2 == A[i] && candidate2 != B[i]) {
                count1++
            }
        }

        return when {
            candidate1 in possibleCandidates && candidate2 in possibleCandidates -> minOf(count1, count2)
            candidate1 in possibleCandidates -> count2
            else -> count1
        }
    }
}