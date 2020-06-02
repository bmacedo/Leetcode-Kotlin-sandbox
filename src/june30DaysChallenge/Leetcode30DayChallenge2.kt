package june30DaysChallenge

import utils.ListNode
import utils.toList
import utils.toListNode

/**
 * Delete Node in a Linked List
 *
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 */
fun main(args: Array<String>) {
    val listNode = intArrayOf(4, 5, 1, 9).toListNode()
    Leetcode30DayChallenge2.deleteNode(listNode.next)
    println(listNode.toList())
}

object Leetcode30DayChallenge2 {
    fun deleteNode(node: ListNode?) {
        node?.next?.let {
            node.`val` = it.`val`
            node.next = it.next
        }
    }
}