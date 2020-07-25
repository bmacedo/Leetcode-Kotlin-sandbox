package contests.biweeklyContest29

/**
 * The kth Factor of n
 *
 * Given two positive integers n and k.
 *
 * A factor of an integer n is defined as an integer i where n % i == 0.
 *
 * Consider a list of all factors of n sorted in ascending order, return the kth factor in
 * this list or return -1 if n has less than k factors.
 */
fun main(args: Array<String>) {
    val n = 12
    val k = 3
    println(KthFactorOfN.kthFactor(n, k))
}

object KthFactorOfN {
    fun kthFactor(n: Int, k: Int): Int {
        val factors = mutableListOf<Int>()
        for (i in 1..n) {
            if (n % i == 0) factors.add(i)
        }
        return if (factors.size >= k) factors[k - 1] else -1
    }
}