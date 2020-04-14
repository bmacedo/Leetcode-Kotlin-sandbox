package thirtyDaysChallenge


/**
 * Given a binary array, find the maximum length of a contiguous
 * subarray with equal number of 0 and 1.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(0,1) // expect 2: [0,1]
//    val input = intArrayOf(0,0,0,0,1,0,1,0,1) // expect 6: [0,1,0,1,0,1]
//    val input = intArrayOf(0,0,0,1,1,1,1,0,1) // expect 8: [0,0,0,1,1,1,1,0]
//    val input = intArrayOf(0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1)
    println(Leetcode30DayChallenge13.findMaxLength(input))
}

object Leetcode30DayChallenge13 {

    fun findMaxLength(nums: IntArray): Int {
        val amounts = mutableListOf(0)
        val hash = HashMap<Int, Pair<Int, Int>>()
        hash[0] = Pair(0,0)
        for (i in 1 .. nums.size) {
            amounts.add(amounts[i-1] + (if (nums[i-1] == 0) -1 else 1))
            val sum = amounts[i]
            if (hash[sum] != null) {
                val currentPair = hash[sum]!!
                hash[sum] = currentPair.copy(second = i - currentPair.first)
            } else {
                hash[sum] = Pair(i, 0)
            }
        }

        var max = 0
        for (entry in hash) {
            if (entry.value.second > max) {
                max = entry.value.second
            }
        }
        return max
    }

//    fun findMaxLength(nums: IntArray): Int {
//        var max = 0
//        for (i in nums.indices) {
//            var j = nums.size
//            while (j > i) {
//                val arr = nums.copyOfRange(fromIndex = i, toIndex = j)
//                if (hasSameNumberOfZerosAndOnes(arr)) {
//                    if (max < arr.size) {
//                        max = arr.size
//                        println("size = $max; arr = ${arr.toList()}")
//                    }
//                    j -= 2
//                } else {
//                    j--
//                }
//            }
//        }
//        return max
//    }
//
//    private fun hasSameNumberOfZerosAndOnes(arr: IntArray): Boolean {
//        return arr.size % 2 == 0 && arr.size == arr.sum() * 2
//    }

}
