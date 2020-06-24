package june30DaysChallenge


/**
 * Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Note: The resulting sequence is called the Catalan sequence. You're looking for the nth catalan number
 */
fun main(args: Array<String>) {
    val input = 4
    println(Leetcode30DayChallenge24.numTrees(input))
}

object Leetcode30DayChallenge24 {

    // numTrees(n) = f(1,n) + f(2,n) + ... + f(n,n)
    // f(i,n) = numTrees(i-1) * numTrees(n-i) /* i-1 = # of nodes lt i; n-i = # of nodes gt i */
    val hash = HashMap<Int, Int>().apply { put(0, 1); put(1, 1) }
    fun numTrees(n: Int): Int {
        fun f(i: Int, n: Int): Int = numTrees(i - 1) * numTrees(n - i)
        return hash[n] ?: (1..n).fold(0) { acc, i -> acc + f(i, n) }.also { hash[n] = it }
    }

    // same, but iterative instead of recursive
    fun numTreesIterative(n: Int): Int {
        val catalan = IntArray(n + 1)
        catalan[0] = 1
        catalan[1] = 1
        for (i in 2..n) {
            for (j in 1..i) {
                catalan[i] += catalan[j - 1] * catalan[i - j]
            }
        }
        return catalan[n]
    }
}
