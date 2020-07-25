package practice.arrays101

/**
 * Replace Elements with Greatest Element on Right Side
 *
 * Given an array arr, replace every element in that array with the greatest element
 * among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(17,18,5,4,6,1)
    println(ReplaceElementsWithGreatestElementOnRightSide.replaceElements(input).toList())
}

object ReplaceElementsWithGreatestElementOnRightSide {

    // O(n)
    fun replaceElements(arr: IntArray): IntArray {
        var max = -1
        for (i in arr.lastIndex downTo 0) {
            val temp = arr[i]
            arr[i] = max
            max = temp.coerceAtLeast(max)
        }
        return arr
    }
    // O(nlogn) time O(n) space
    fun replaceElementsSlow(arr: IntArray): IntArray {
        var currentIndex = 0
        val sortedArr = arr.sortedDescending().toMutableList()

        while (currentIndex < arr.size) {
            sortedArr.remove(arr[currentIndex])
            arr[currentIndex] = sortedArr.firstOrNull() ?: -1
            currentIndex++
        }
        return arr
    }
}