package contest188

/**
 * Count Triplets That Can Form Two Arrays of Equal XOR
 *
 * Given an array of integers arr.
 * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
 *
 * Let's define a and b as follows:
 * - a = arr[ i ] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * - b = arr[ j ] ^ arr[j + 1] ^ ... ^ arr[ k ]
 *
 * Note that ^ denotes the bitwise-xor operation.
 * Return the number of triplets (i, j and k) Where a == b.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(7,11,12,9,5,2,7,17,22)
    println(CountTripletsThatCanFormTwoArraysOfEqualXOR.countTriplets(input))
}

object CountTripletsThatCanFormTwoArraysOfEqualXOR {
    fun countTriplets(arr: IntArray): Int {
        var count = 0
        for (i in 0 until arr.lastIndex) {
            for (j in i+1 until arr.size) {
                for (k in j until arr.size) {
                    if (isTriplet(arr, i, j, k)) count++
                }
            }
        }
        return count
    }

    private fun isTriplet(arr: IntArray, i: Int, j: Int, k: Int): Boolean {
        var a = -1
        for (index in i until j) {
            a = a xor arr[index]
        }
        var b = -1
        for (index in j..k) {
            b = b xor arr[index]
        }
        return a == b
    }
}