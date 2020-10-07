package challenges.october30DaysChallenge

import utils.ListNode
import utils.toList
import utils.toListNode


/**
 * Insert into a Binary Search Tree
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does
 * not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains
 * a BST after insertion. You can return any of them.
 */
fun main(args: Array<String>) {
    val head = intArrayOf(1, 2, 3, 4, 5).toListNode()
    println(Day7.rotateRight(head, 2).toList())
}

object Day7 {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null

        var start = head
        var end = head
        var len = 0
        while (end?.next != null) {
            end = end.next
            len++
        }
        val modK = k % (len + 1)

        if (modK == 0) return head

        end?.next = start
        var node = start
        repeat(len - modK) {
            node = node?.next
        }
        start = node?.next
        node?.next = null

        return start
    }
}