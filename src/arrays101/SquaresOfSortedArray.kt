package arrays101

/**
 * Squares of a Sorted Array
 *
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(-2, -1, 3)
    println(SquaresOfSortedArray.sortedSquares(input).toList())
}

object SquaresOfSortedArray {

    fun sortedSquares(A: IntArray): IntArray {
        // O(nlogn)
        val indexOfFirstPositive = binarySearchFirstPositive(A)

        // O(n)
        if (indexOfFirstPositive != -1) {
            val firstPart = A.copyOfRange(0, indexOfFirstPositive).reversedArray()
            val secondPart = A.copyOfRange(indexOfFirstPositive, A.size)
            var i = 0
            var firstPartIndex = 0
            var secondPartIndex = 0
            val output = mutableListOf<Int>()
            while (i < A.size) {
                if (firstPartIndex in firstPart.indices && secondPartIndex in secondPart.indices) {
                    val square1 = firstPart[firstPartIndex] * firstPart[firstPartIndex]
                    val square2 = secondPart[secondPartIndex] * secondPart[secondPartIndex]
                    if (square1 < square2) {
                        output.add(square1)
                        firstPartIndex++
                    } else {
                        output.add(square2)
                        secondPartIndex++
                    }
                } else if (firstPartIndex in firstPart.indices) {
                    output.add(firstPart[firstPartIndex] * firstPart[firstPartIndex])
                    firstPartIndex++
                } else {
                    output.add(secondPart[secondPartIndex] * secondPart[secondPartIndex])
                    secondPartIndex++
                }

                i++
            }
            return output.toIntArray()
        } else {
            return A.reversedArray().map { it * it }.toIntArray()
        }
    }

    private fun binarySearchFirstPositive(arr: IntArray): Int {
        var start = 0
        var end = arr.lastIndex
        while (start < end) {
            val mid = (start + end) / 2
            if (arr[mid] < 0) {
                start = mid + 1
            } else {
                end = mid
            }
        }
        return if (arr[start] >= 0) start else -1
    }

}