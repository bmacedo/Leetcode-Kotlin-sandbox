package adhoc

import utils.ListNode
import utils.toList
import utils.toListNode

/**
 * Reverse Linked List
 *
 * Reverse a singly linked list.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 3, 4, 5).toListNode()
    println(ReverseLinkedList.reverseList(input).toList())
}

object ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var prev: ListNode? = null
        while (node != null) {
            val temp = node.next
            node.next = prev
            prev = node
            node = temp
        }
        return prev
    }
}