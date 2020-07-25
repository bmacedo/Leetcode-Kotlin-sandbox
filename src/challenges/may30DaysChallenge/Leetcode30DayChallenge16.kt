package challenges.may30DaysChallenge

import utils.ListNode
import utils.toList
import utils.toListNode

/**
 * Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 *
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place.
 *
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Note:
 * -    The relative order inside both the even and odd groups should remain as it was in the input.
 * -    The first node is considered odd, the second node even and so on ...

 */
fun main(args: Array<String>) {
    val input = intArrayOf(1,2,3,4,5,6).toListNode()
    println(Leetcode30DayChallenge16.oddEvenList(input).toList())
}

object Leetcode30DayChallenge16 {

    // O(n) time, O(1) space
    fun oddEvenList(head: ListNode?): ListNode? {
        val temp = head?.next
        var current = head
        var i = 0
        while (current != null) {
            val next = current.next
            if (next == null) {
                if (i % 2 == 0) current.next = temp
            } else {
                current.next = if (i % 2 == 0 && next.next == null) temp else next.next
            }
            current = next
            i++
        }
        return head
    }
}


