package practice.arrays101

/**
 * Duplicate Zeros
 *
 * Given a fixed length array arr of integers, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1,0,2,3,0,4,5,0)
    DuplicateZeros.duplicateZeros(input)
    println(input.toList())
}

object DuplicateZeros {

    // O(n) time O(1) space
    fun duplicateZeros(arr: IntArray) {
        var countOfZeros = 0
        arr.forEach { if (it == 0) countOfZeros++ }

        var i = arr.lastIndex
        var j = i + countOfZeros
        while (i >= 0 && j >= 0) {
            if (arr[i] == 0) {
                if (j in arr.indices) arr[j] = 0
                j--
                if (j in arr.indices) arr[j] = 0
            } else {
                if (j in arr.indices) arr[j] = arr[i]
            }
            i--
            j--
        }
    }

    // O(n) time O(n) space
    fun duplicateZerosWithSpace(arr: IntArray) {
        val tempList = mutableListOf<Int>()
        arr.forEach {
            if (it == 0) {
                tempList.add(it)
                tempList.add(it)
            } else {
                tempList.add(it)
            }
        }
        for (i in arr.indices) {
            arr[i] = tempList[i]
        }
    }
}