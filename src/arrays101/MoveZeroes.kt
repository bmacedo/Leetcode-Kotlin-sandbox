package arrays101

/**
 * Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1,0,0)
    MoveZeroes.moveZeroes(input)
    print(input.toList())
}

object MoveZeroes {
    fun moveZeroes(nums: IntArray) {
        var i = 0
        var j = 0
        while (j < nums.size) {
            while (j < nums.lastIndex && nums[j] == 0) j++
            if (j <= nums.lastIndex && nums[j] != 0) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                i++
            }
            j++
        }
    }
}