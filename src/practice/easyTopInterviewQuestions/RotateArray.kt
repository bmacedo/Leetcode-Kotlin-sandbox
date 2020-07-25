package practice.easyTopInterviewQuestions

/**
 * Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Could you do it in-place with O(1) extra space?
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1,2,3,4)
    val k = 2
    RotateArray.rotate(input, k)
    println(input.toList())
}

object RotateArray {

    // O(n) time, O(1) space, multiple pass
    fun rotate(nums: IntArray, k: Int) {
        val shifts = Math.floorMod(k, nums.size)
        reverse(nums, 0, nums.lastIndex)
        reverse(nums, 0, shifts-1)
        reverse(nums, shifts, nums.lastIndex)
    }

    private fun reverse(arr: IntArray, start: Int, end: Int) {
        var first = start
        var last = end
        while (first < last) {
            val temp = arr[first]
            arr[first] = arr[last]
            arr[last] = temp
            first++
            last--
        }
    }

    // O(n) time, O(n) space
    fun rotateSpacey(nums: IntArray, k: Int) {
        val mirror = mutableListOf<Int>()
        var i = 0
        while (i < nums.size) {
            mirror.add(nums[Math.floorMod(i-k, nums.size)])
            i++
        }
        for (j in mirror.indices) {
            nums[j] = mirror[j]
        }
    }

    // O(n*k) time, O(1) space
    fun rotateSlow(nums: IntArray, k: Int) {
        for(i in 0 until Math.floorMod(k, nums.size)) {
            val temp = nums.last()
            for (j in nums.lastIndex downTo 1) {
                nums[j] = nums[j-1]
            }
            nums[0] = temp
        }
    }
}