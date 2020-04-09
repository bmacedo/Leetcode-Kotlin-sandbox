package thirtyDaysChallenge

import utils.ListNode
import utils.toListNode

fun main(args: Array<String>) {
//    val input = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8).`30daychallenge`.toListNode()
//    val input = intArrayOf(1,2,3,4,5).`30daychallenge`.toListNode()
    val input = intArrayOf(1,2,3,4,5,6).toListNode()
    println(Leetcode30DayChallenge8.middleNodeSolution2(input))
}

object Leetcode30DayChallenge8 {

    // O(N) time, O(1) space
    fun middleNodeSolution2(head: ListNode?): ListNode? {
        var slowPointer = head
        var fastPointer = head
        while (fastPointer?.next != null) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
        }
        return slowPointer
    }

    // O(N) time, O(N) space
    fun middleNodeSolution1(head: ListNode?): ListNode? {
        val mirroredList = mutableListOf<ListNode>()
        head?.let { mirroredList.add(it) }
        var currentNode = head?.next
        while (currentNode != null) {
            mirroredList.add(currentNode)
            currentNode = currentNode.next
        }
        val middleIndex = if (mirroredList.size % 2 == 0) (mirroredList.lastIndex/2) + 1 else mirroredList.lastIndex/2
        return mirroredList[middleIndex]
    }
}
