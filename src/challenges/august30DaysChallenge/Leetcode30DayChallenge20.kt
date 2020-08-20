package challenges.august30DaysChallenge

import utils.ListNode
import utils.toList
import utils.toListNode
import java.util.*
import kotlin.test.assertEquals


/**
 * Reorder List
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
fun main(args: Array<String>) {

    run {
        val list = intArrayOf(1, 2, 3, 4).toListNode()
        Leetcode30DayChallenge20.reorderList(list)
        assertEquals(listOf(1, 4, 2, 3), list.toList())
    }

    run {
        val list = intArrayOf(1, 2, 3, 4, 5).toListNode()
        Leetcode30DayChallenge20.reorderList(list)
        assertEquals(listOf(1, 5, 2, 4, 3), list.toList())
    }

    println("Success")
}

object Leetcode30DayChallenge20 {


    // O(n) time, O(n) space
    fun reorderList(head: ListNode?) {
        var current = head
        val stack = Stack<ListNode>()
        while (current != null) {
            stack.push(current)
            current = current.next
        }

        current = head
        var count = 0
        val mid = stack.size / 2
        while (count < mid) {
            val temp = current?.next
            val node = stack.pop()
            current?.next = node
            current?.next?.next = temp
            current = temp
            count++
        }
        current?.next = null
    }

    // O(n square) time, O(1) space
    fun reorderListSlowButNoExtraSpace(head: ListNode?) {
        var node = head
        // O(n)
        while (node?.next != null) {
            val temp = node.next
            var current = node
            var next = temp
            // O(n)
            while (next?.next != null) {
                current = next
                next = next.next
            }
            current?.next = null
            node.next = next
            if (next != temp) next?.next = temp
            node = temp
        }
    }
}