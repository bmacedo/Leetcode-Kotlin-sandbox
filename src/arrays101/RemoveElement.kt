package arrays101

/**
 * Remove Element
 *
 * Given an array nums and a value val, remove all instances of that value in-place
 * and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the
 * input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the
 * new length.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(0,1,2,2,3,0,4,2)
    val value = 2
    println(RemoveElement.removeElement(input, value))
}

object RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = nums.lastIndex
        while (i <= j) {
            if (nums[i] == `val`) {
                nums[i] = nums[j]
                j--
            } else {
                i++
            }
        }
        return j + 1
    }
}