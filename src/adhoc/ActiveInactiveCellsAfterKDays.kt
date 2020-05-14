package adhoc

/**
 * https://www.geeksforgeeks.org/active-inactive-cells-k-days/
 */
fun main(args: Array<String>) {
    val input = intArrayOf(0, 1, 0, 1, 0, 1, 0, 1)
    val k = 3
    println(ActiveInactiveCellsAfterKDays.stateAfterKDays(input, k).toList())
}

object ActiveInactiveCellsAfterKDays {
    fun stateAfterKDays(arr: IntArray, k: Int): IntArray {
        val result = arr.copyOf()
        repeat(k) {
            for (i in arr.indices) {
                val leftNeighbor = if (i == 0) 0 else arr[i-1]
                val rightNeighbor = if (i == arr.lastIndex) 0 else arr[i+1]
                val shouldToggle = leftNeighbor == rightNeighbor
                result[i] = if (shouldToggle) 0 else 1
            }
            for (i in arr.indices) arr[i] = result[i]
        }
        return result
    }
}