package adhoc

import utils.ListNode
import utils.println
import utils.toListNode

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
fun main(args: Array<String>) {
    val input1 = intArrayOf(9,9,9,9).toListNode()
    val input2 = intArrayOf(9,9,9,9).toListNode()
    AddTwoNumbers.addTwoNumbers(input1, input2).println()
}

object AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carryOver = 0
        var currentDigit1 = l1
        var currentDigit2 = l2
        var resultHead: ListNode? = null
        var currentResult: ListNode? = null
        while (currentDigit1 != null || currentDigit2 != null || carryOver != 0) {
            val sum = carryOver + currentDigit1?.`val`.orZero() + currentDigit2?.`val`.orZero()
            val resultingDigit = sum % 10
            carryOver = sum / 10
            currentDigit1 = currentDigit1?.next
            currentDigit2 = currentDigit2?.next
            if (resultHead == null) {
                resultHead = ListNode(resultingDigit)
                currentResult = resultHead
            } else {
                currentResult?.next = ListNode(resultingDigit)
                currentResult = currentResult?.next
            }
        }

        return resultHead
    }

    private fun Int?.orZero(): Int = this ?: 0
}
