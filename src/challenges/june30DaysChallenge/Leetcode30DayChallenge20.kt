package challenges.june30DaysChallenge


/**
 * Permutation Sequence
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 * Note:
 * - Given n will be between 1 and 9 inclusive.
 * - Given k will be between 1 and n! inclusive.
 */
fun main(args: Array<String>) {
    val n = 9
    val k = 135401
//    val n = 3
//    val k = 3
    println(Leetcode30DayChallenge20.getPermutation(n, k))
}

object Leetcode30DayChallenge20 {

    // Brute force
    fun getPermutation(n: Int, k: Int): String {
        if (n < 1 || k < 1) return ""
        val list = (1..n).toList().toIntArray()
        val permutations = mutableSetOf<IntArray>()
        var isFinished = false
        while (!isFinished) {
            permutations.add(list.copyOf())

            if (permutations.size == k) break

            var firstCharIndex = n - 2
            while (firstCharIndex >= 0) {
                if (list[firstCharIndex] < list[firstCharIndex + 1]) break
                firstCharIndex--
            }

            if (firstCharIndex == -1) {
                isFinished = true
            } else {
                val ceilIndex = findCeil(list, list[firstCharIndex], firstCharIndex + 1, n - 1)
                list.swap(firstCharIndex, ceilIndex)
                reverse(list, firstCharIndex + 1, n - 1)
            }
        }
        return permutations.toList()[k - 1].joinToString(separator = "")
    }

    private fun reverse(list: IntArray, l: Int, h: Int) {
        var i = l
        var j = h
        while (i < j) {
            list.swap(i, j)
            i++
            j--
        }
    }

    private fun findCeil(list: IntArray, first: Int, l: Int, h: Int): Int {
        var ceilIndex = l
        for (i in l + 1..h) {
            if (list[i] > first && list[i] < list[ceilIndex]) {
                ceilIndex = i
            }
        }
        return ceilIndex
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
