package practice.arrays101

/**
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that
 * each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(2,2)
    println(RemoveDuplicatesFromSortedArray.removeDuplicates(input))
}

object RemoveDuplicatesFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var j = 1
        while (j < nums.size) {
            if (nums[j] != nums[i]) {
                i++
                nums[i] = nums[j]
            }
            j++
        }
        return i + 1
    }

    fun removeDuplicatesSlow(nums: IntArray): Int {
        var n = nums.size
        var i = 1
        while (i < n) {
            if (nums[i - 1] == nums[i]) {
                var j = i + 1
                while (j < n && nums[j] == nums[i]) j++

                for (k in 0 until (n - j)) {
                    nums[i + k] = nums[j+k]
                }
                n -= (j-i)
            }
            i++
        }
        return n
    }
}


//var i = 0
//var n = nums.size
//while (i < n) {
//    var j = i + 1
//    var count = 1
//    while (j in nums.indices && nums[i] == nums[j]) {
//        count++
//        j++
//    }
//    if (j > nums.lastIndex) {
//        i++
//        break
//    }
//    if (i+count <= nums.lastIndex && j > i+1) {
//        for (k in 1 until count) {
//            nums[i+k] = nums[j]
//        }
//        n--
//    }
//    i++
//}
//return i