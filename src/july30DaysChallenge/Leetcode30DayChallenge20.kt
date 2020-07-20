package july30DaysChallenge

import utils.ListNode
import utils.toList
import utils.toListNode


/**
 * Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 1).toListNode()
    val n = 1
    println(Leetcode30DayChallenge20.removeElements(input, n).toList())
}


object Leetcode30DayChallenge20 {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head

        var prev: ListNode? = dummy
        var curr = head
        while (curr != null) {
            if (curr.`val` == `val`) {
                prev?.next = curr.next
            } else {
                prev = prev?.next
            }
            curr = curr.next
        }
        return dummy.next
    }

    // Leetcode does not accept below solution, not sure why. Fails for input [1,1], n = 1.
//    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
//        val value = `val`
//        var root = head
//        var node = head
//        var prev: ListNode? = null
//        while (node != null) {
//            if (node.`val` == value) {
//                if (prev == null || prev == root) {
//                    root = node.next
//                } else {
//                    prev.next = node.next
//                }
//            }
//            prev = node
//            node = node.next
//        }
//        return root
//    }
}
