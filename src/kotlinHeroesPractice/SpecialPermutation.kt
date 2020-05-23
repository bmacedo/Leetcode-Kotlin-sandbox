package kotlinHeroesPractice

/**
 *
 * A permutation of length 𝑛 is an array 𝑝=[𝑝1,𝑝2,…,𝑝𝑛], which contains every integer from 1 to 𝑛 (inclusive)
 * and, moreover, each number appears exactly once.
 *
 * For example, 𝑝=[3,1,4,2,5] is a permutation of length 5.
 *
 * For a given number 𝑛 (𝑛≥2), find a permutation 𝑝 in which absolute difference (that is, the absolute
 * value of difference) of any two neighboring (adjacent) elements is between 2 and 4, inclusive.
 *
 * Formally, find such permutation 𝑝 that 2≤|𝑝𝑖−𝑝𝑖+1|≤4 for each 𝑖 (1≤𝑖<𝑛).
 *
 * Print any such permutation for the given integer 𝑛 or determine that it does not exist.
 *
 * Print a permutation that meets the given requirements.
 * If there are several such permutations, then print any of them.
 * If no such permutation exists, print -1.
 */
fun main(args: Array<String>) {
    val times = readLine()!!.toInt()
    repeat(times) {
        val n = readLine()!!.toInt()
        SpecialPermutation.findSpecialPermutation(n)
    }
}

object SpecialPermutation {

    // Print odd numbers, then even numbers, replacing the first even number with the second even number
    fun findSpecialPermutation(n: Int) {
        if (n <= 3) {
            println("-1")
            return
        }

        val odd = (1..n).filter { it % 2 != 0 }.reversed()
        val even = (1..n).filter { it % 2 == 0 }.toMutableList()

        // swap first 2 even numbers
        val temp = even[0]
        even[0] = even[1]
        even[1] = temp

        (odd + even).forEach { print("$it ") }
        println()
    }

    // brute force backtracking
    fun findSpecialPermutationBacktracking(n: Int) {
        val list = mutableSetOf<Int>()
        for (i in 3..n) {
            addOptions(n, list, (1..n).toList())
            if (list.size == n) {
                for (item in list) print("$item ")
                println()
                return
            } else {
                list.clear()
            }
        }
        println("-1")
    }

    private fun addOptions(n: Int, list: MutableSet<Int>, options: List<Int>) {
        options.forEach { option ->
            val localList = mutableSetOf<Int>().apply {
                addAll(list)
                add(option)
            }
            val newOptions = (1..n).filter { it !in localList }.filter { Math.abs(localList.last() - it) in 2..4 }
            if (newOptions.isNotEmpty()) {
                addOptions(n, localList, newOptions)
            }
            if (localList.size == n) {
                list.addAll(localList)
                return
            }
        }
    }
}