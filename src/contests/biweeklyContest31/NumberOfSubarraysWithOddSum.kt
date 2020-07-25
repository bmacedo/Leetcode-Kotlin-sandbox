package contests.biweeklyContest31

/**
 * Number of Sub-arrays With Odd Sum
 *
 * Given an array of integers arr. Return the number of sub-arrays with odd sum.
 *
 * As the answer may grow large, the answer must be computed modulo 10^9 + 7.
 */
fun main(args: Array<String>) {
    val arr = intArrayOf(1, 3, 5)
    println(NumberOfSubarraysWithOddSum.numOfSubarrays(arr))
}

object NumberOfSubarraysWithOddSum {

    val MAX = Math.pow(10.0, 9.0).toLong() + 7

    fun numOfSubarrays(arr: IntArray): Int {
        val temp = longArrayOf(1, 0)
        var value = 0
        for (i in 0 until arr.size) {
            value = ((value + arr[i]) % 2 + 2) % 2
            temp[value]++
        }
        return Math.floorMod(temp[0] * temp[1], MAX).toInt()
    }


    // Time limit exceeded
    fun numOfSubarraysSlow(arr: IntArray): Int {
        val MAX = Math.pow(10.0, 9.0).toLong() + 7

        val sums = mutableListOf<Int>()
        if (arr.isNotEmpty()) {
            for (count in 0 until arr.size) {
                var i = 0
                while (i + count < arr.size) {
                    var sum = 0L
                    for (j in i..i + count) sum += arr[j]
                    if (sum % 2L == 1L && sum < MAX) sums.add(sum.toInt())
                    i++
                }
            }
        }
        return sums.count()
    }

}