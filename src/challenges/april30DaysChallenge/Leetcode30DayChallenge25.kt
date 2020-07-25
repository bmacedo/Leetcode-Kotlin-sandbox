package challenges.april30DaysChallenge

import java.util.*
import kotlin.collections.HashMap


/**
 * Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 */

fun main(args: Array<String>) {
    val input = intArrayOf(2, 3, 1, 1, 4)
//    val input = readInts().toIntArray()
    println(Leetcode30DayChallenge25.canJump(input))
}

object Leetcode30DayChallenge25 {

    fun canJump(nums: IntArray): Boolean {
        return canReachEndOptimal(nums)
    }

    // O(n) S(1)
    private fun canReachEndOptimal(arr: IntArray): Boolean {
        var lastGoodPosition = arr.lastIndex

        for (i in arr.lastIndex - 1 downTo 0) {
            if (i + arr[i] >= lastGoodPosition) {
                lastGoodPosition = i
            }
        }

        return lastGoodPosition == 0
    }

    // O(n square) S(n square)
    private fun canReachEndIterative(arr: IntArray): Boolean {
        val hashMap = HashMap<Int, Boolean>()
        val stack = Stack<Int>()
        stack.push(0)
        while (!stack.isEmpty()) {
            val i = stack.pop()
            if (i >= arr.lastIndex || arr[i] == arr.lastIndex - i) return true
            if (hashMap[i] == false) continue
            for (j in 1..arr[i]) {
                if (i + j < arr.size && !hashMap.containsKey(i + j)) {
                    stack.push(i + j)
                }
            }
            hashMap[i] = false
        }
        return false
    }
}
