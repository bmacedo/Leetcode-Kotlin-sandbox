package practice.easyTopInterviewQuestions

import utils.ListNode
import utils.toListNode

/**
 * Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 */
fun main(args: Array<String>) {
    println(PalindromeLinkedList.isPalindrome(intArrayOf(1, 2, 3, 2, 1).toListNode()))
}

object PalindromeLinkedList {

    fun isPalindrome(head: ListNode?): Boolean {
        var mid = head
        var start = head
        var end = head
        var count = 0
        while (end?.next != null) {
            mid = mid?.next
            end = end.next
            if (end?.next != null) {
                end = end?.next
                count++
            }
            count++
        }

        if (count % 2 == 0) {
            mid = mid?.next
        }

        // reverse second part of list
        var prev: ListNode? = null
        var node = mid
        var temp = node
        while (temp != null) {
            temp = node?.next
            node?.next = prev
            prev = node
            if (temp != null) node = temp
        }


        while (node != null) {
            if (start?.`val` != node.`val`) return false
            start = start.next
            node = node.next
        }

        return true
    }
}