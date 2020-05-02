package arrays101

/**
 * Max Consecutive Ones
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 1, 0, 1, 1, 1)
    println(MaxConsecutiveOnes.findMaxConsecutiveOnes(input))
}

object MaxConsecutiveOnes {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var count = 0
        nums.forEach { num ->
            count = if (num == 0) 0 else count + 1
            if (max < count) {
                max = count
            }
        }
        return max
    }

}