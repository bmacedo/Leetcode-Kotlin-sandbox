package challenges.september30DaysChallenge


/**
 * Largest Time for Given Digits
 *
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.
 * Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 */
fun main(args: Array<String>) {
    println(Day1.largestTimeFromDigits(intArrayOf(2, 0, 6, 6)))
}

object Day1 {
    fun largestTimeFromDigits(A: IntArray): String {
        return largestTimeFromDigits(A, 2)
    }

    private fun largestTimeFromDigits(_A: IntArray, maxFirst: Int): String {
        val arr = _A.copyOf()
        if (maxFirst < 0) return ""

        val firstIndex = findLargestValidIndex(arr, maxFirst)
        if (firstIndex == -1) return ""
        val firstValue = arr[firstIndex]
        arr[firstIndex] = -1

        val maxSecond = if (firstValue == 2) 3 else 9
        val secondIndex = findLargestValidIndex(arr, maxSecond)
        if (secondIndex == -1) return largestTimeFromDigits(_A, maxFirst - 1)
        val secondValue = arr[secondIndex]
        arr[secondIndex] = -1

        val thirdIndex = findLargestValidIndex(arr, 5)
        if (thirdIndex == -1) return largestTimeFromDigits(_A, maxFirst - 1)
        val thirdValue = arr[thirdIndex]
        arr[thirdIndex] = -1

        val fourthIndex = findLargestValidIndex(arr, 9)
        if (fourthIndex == -1) return largestTimeFromDigits(_A, maxFirst - 1)
        val fourthValue = arr[fourthIndex]
        arr[fourthIndex] = -1

        return "$firstValue$secondValue:$thirdValue$fourthValue"
    }

    private fun findLargestValidIndex(A: IntArray, maxValue: Int): Int {
        var maxIndex = -1
        for (i in A.indices) {
            if (A[i] in 0..maxValue) {
                if (maxIndex == -1 || (A[i] <= maxValue && A[i] > A[maxIndex])) {
                    maxIndex = i
                }
            }
        }
        return maxIndex
    }
}