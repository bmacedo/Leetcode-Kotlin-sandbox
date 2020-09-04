package challenges.september30DaysChallenge


/**
 * Partition Labels
 *
 * A string S of lowercase English letters is given. We want to partition this string into
 * as many parts as possible so that each letter appears in at most one part, and return a
 * list of integers representing the size of these parts.
 */
fun main(args: Array<String>) {
    println(Day4.partitionLabels("ababcbacadefegdehijhklij"))
}

object Day4 {

    // O(n log n) time, O(n) space
    fun partitionLabels(S: String): List<Int> {
        val map = HashMap<Char, MutableList<Int>>() // Char, List<Index>

        // First map together a list of every index that contains the same chars
        // O(n)
        S.forEachIndexed { index, char -> map[char] = map.getOrDefault(char, mutableListOf()).apply { add(index) } }

        // Select only the first and last element of each list, sort it
        // O(k log k), where k is the number of unique chars
        val partitions = map.values
                .map { Pair(it.first(), it.last()) }
                .sortedBy { it.first }
                .toMutableList()

        if (partitions.size == 1) return listOf(partitions[0].second + 1)

        // Merge the partitions together
        // O(k), where k is the number of unique chars
        var i = 0
        while (i < partitions.lastIndex) {
            val (start, end) = partitions[i]
            val (nextStart, nextEnd) = partitions[i + 1]

            // Check if needs to be merged
            if (nextStart < end) {
                partitions.remove(partitions[i])
                partitions.add(i, Pair(start, maxOf(end, nextEnd)))
                partitions.remove(partitions[i + 1])
            } else {
                i++
            }
        }

        // Map the partitions into the result wanted: the size of each partition
        // O(m), where m is the number of partitions
        return partitions.map { (it.second + 1) - it.first }
    }
}