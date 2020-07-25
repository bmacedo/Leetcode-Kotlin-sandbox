package challenges.july30DaysChallenge


/**
 * Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 1, 2, 2, 3, 3, 3, 3)
    val k = 2
    println(Leetcode30DayChallenge17.topKFrequent(input, k).toList())
}


object Leetcode30DayChallenge17 {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val hash = HashMap<Int, Int>() // Num, Count
        val inverse = HashMap<Int, List<Int>>() // Count, Nums
        nums.forEach { num ->
            val count = hash.getOrDefault(num, 0) + 1
            hash[num] = count
        }

        hash.forEach { num, count ->
            inverse[count] = inverse.getOrDefault(count, listOf()) + listOf(num)
        }

        return inverse
                .toSortedMap(kotlin.Comparator { o1, o2 -> -o1.compareTo(o2) })
                .values
                .flatten()
                .take(k)
                .toIntArray()
    }
}
