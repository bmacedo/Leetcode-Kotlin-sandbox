package biweeklyContest27

/**
 * Make Two Arrays Equal by Reversing Sub-arrays
 *
 * Given two integer arrays of equal length target and arr.
 *
 * In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
 *
 * Return True if you can make arr equal to target, or False otherwise.
 */
fun main(args: Array<String>) {
    val target = intArrayOf(1, 2, 3, 4)
    val arr = intArrayOf(2, 4, 1, 3)
    println(MakeTwoArraysEqualByReversingSubArrays.canBeEqual(target, arr))
}

object MakeTwoArraysEqualByReversingSubArrays {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val hashTarget = HashMap<Int, Int>() // Int, Count

        if (target.size != arr.size) return false
        for (num in target) {
            hashTarget[num] = hashTarget.getOrDefault(num, 0) + 1
        }
        for (num in arr) {
            hashTarget[num] = hashTarget.getOrDefault(num, 0) - 1
        }
        hashTarget.forEach { (_, count) -> if (count != 0) return false }
        return true
    }
}