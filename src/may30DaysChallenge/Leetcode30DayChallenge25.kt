package may30DaysChallenge


/**
 * Uncrossed Lines
 *
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers A[ i ] and B[ j ] such that:
 *
 * -    A[ i ] == B[ j ];
 * -    The line we draw does not intersect any other connecting (non-horizontal) line.
 *
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to
 * one connecting line.
 *
 * Return the maximum number of connecting lines we can draw in this way.
 */
fun main(args: Array<String>) {
    val A = intArrayOf(2, 3, 4, 1, 3, 3, 2, 4, 2, 2, 1, 5, 2, 4, 3, 4, 4, 5, 1, 5, 1, 5, 4, 3, 1, 2, 5, 2, 4, 4)
    val B = intArrayOf(2, 2, 4, 2, 4, 1, 1, 5, 5, 3, 2, 1, 1, 1, 3, 1, 2, 5, 2, 4, 3, 4, 5, 5, 3, 3, 5, 1, 4, 3)
    println(Leetcode30DayChallenge25.maxUncrossedLines(A, B))
}

object Leetcode30DayChallenge25 {

    // Mind-blowing moment: this problem is basically the same as the Longest Common Subsequence problem
    // but instead of using strings, it uses a int array. <insert meme exploding head here.>
    // By using DP we can optimize this to O(n*m)
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val dp = Array(A.size + 1) { IntArray(B.size + 1) { -1 } }
        return lcs(A, B, 0, 0, dp)
    }

    private fun lcs(A: IntArray, B: IntArray, i: Int, j: Int, dp: Array<IntArray>): Int {
        if (i == A.size || j == B.size) return 0

        if (dp[i][j] == -1) {
            if (A[i] == B[j]) {
                // if (i) and (j) are equal, mark the connection and go on with both pointers
                dp[i][j] = 1 + lcs(A, B, i + 1, j + 1, dp)
            } else {
                // if (i) and (j) are different, get the max from increasing only one pointer at a time
                dp[i][j] = Math.max(lcs(A, B, i, j + 1, dp), lcs(A, B, i + 1, j, dp))
            }
        }
        // the max result will always be updated in the last position
        return dp[i][j]
    }

    private val hash = HashMap<Triple<Int, Int, Int>, Int>()
    private val indexList = HashMap<Int, MutableList<Int>>()

    // Naive brute force solution.
    // The complexity here is O(n^m).
    // It passes the leetcode acceptance because of the hash and the indexList,
    // which reduce the complexity a bit.
    fun maxUncrossedLinesSlow(A: IntArray, B: IntArray): Int {
        B.forEachIndexed { index, num ->
            indexList[num] = indexList.getOrDefault(num, mutableListOf()).apply { add(index) }
        }
        return uncrossedLines(A, B, 0, 0, 0)
    }

    private fun uncrossedLines(A: IntArray, B: IntArray, aPtr: Int, bPtr: Int, count: Int): Int {
        if (aPtr !in A.indices || bPtr !in B.indices) return count

        if (hash[Triple(aPtr, bPtr, count)] != null) return hash[Triple(aPtr, bPtr, count)]!!

        val value = A[aPtr]
        val indexesOfValueInB = findIndexesOf(value, bPtr)

        var maxCount = 0
        var temp = uncrossedLines(A, B, aPtr + 1, bPtr, count) // assuming no connection made

        if (maxCount < temp) maxCount = temp

        indexesOfValueInB.forEach { bIndex ->
            temp = uncrossedLines(A, B, aPtr + 1, bIndex + 1, count + 1) // 1 conn was made
            if (maxCount < temp) maxCount = temp
        }

        hash[Triple(aPtr, bPtr, count)] = maxCount
        return maxCount
    }

    private fun findIndexesOf(value: Int, bPtr: Int): List<Int> {
        return indexList.getOrDefault(value, mutableListOf()).filter { it >= bPtr }
    }
}

