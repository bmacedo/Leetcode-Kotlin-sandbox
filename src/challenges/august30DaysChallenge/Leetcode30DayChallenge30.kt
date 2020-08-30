package challenges.august30DaysChallenge

import java.util.*


/**
 * Largest Component Size by Common Factor
 *
 * Given a non-empty array of unique positive integers A, consider the following graph:
 * - There are A.length nodes, labelled A[0] to A[A.length - 1];
 * - There is an edge between A[ i ] and A[ j ] if and only if A[ i ] and A[ j ] share a common factor greater than 1.
 *
 * Return the size of the largest connected component in the graph.
 */
fun main(args: Array<String>) {
    println(Leetcode30DayChallenge30.largestComponentSize(intArrayOf(4, 6, 15, 35)))
}

object Leetcode30DayChallenge30 {

    fun largestComponentSize(A: IntArray): Int {
        val parent = HashMap<Int, Int>()

        for (num in A) {
            var fact = 2
            while (fact * fact <= num) {
                if (num % fact == 0) {
                    union(num, fact, parent)
                    union(num, num / fact, parent)
                }
                fact++
            }
        }

        var max = 1
        val freq = HashMap<Int, Int>()
        for (v in A) {
            val f = find(v, parent)
            if (freq.containsKey(f)) {
                freq[f] = freq[f]!! + 1
                max = Math.max(max, freq[f]!!)
            } else
                freq[f] = 1
        }
        return max
    }

    private fun union(n: Int, m: Int, p: MutableMap<Int, Int>) {
        val findN = find(n, p)
        val findM = find(m, p)
        if (findN < findM)
            p[findM] = findN
        else
            p[findN] = findM
    }

    private fun find(index: Int, parent: MutableMap<Int, Int>): Int {
        var i = index
        if (parent[i] == null) parent[i] = i
        while (i != parent[i]) i = parent[i]!!
        return i
    }
}