package practice.arrays101

/**
 * Check If N and Its Double Exist
 *
 * Given an array arr of integers, check if there exists two integers N and M
 * such that N is the double of M ( i.e. N = 2 * M).
 *
 * More formally check if there exists two indices i and j such that :
 * -    i != j
 * -    0 <= i, j < arr.length
 * -    arr(i) == 2 * arr(j)
 */
fun main(args: Array<String>) {
    val input = intArrayOf(3,1,7,11)
    println(CheckIfNAndItsDoubleExist.checkIfExist(input))
}

object CheckIfNAndItsDoubleExist {
    fun checkIfExist(arr: IntArray): Boolean {
        val hash = HashSet<Int>()
        arr.forEach { num ->
            if ((num % 2 == 0 && hash.contains(num/2)) || hash.contains(num*2)) return true
            hash.add(num)
        }
        return false
    }
}