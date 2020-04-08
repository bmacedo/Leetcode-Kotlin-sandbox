fun main(args: Array<String>) {
//    val input = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8).toListNode()
//    val input = intArrayOf(1,2,3,4,5).toListNode()
    val input = intArrayOf(1,2,3,4,5,6).toListNode()
    println(Leetcode30DayChallenge8.middleNodeSolution2(input))
}

private fun IntArray.toListNode(): Leetcode30DayChallenge8.ListNode {
    val head = Leetcode30DayChallenge8.ListNode(this[0])
    nextNode(head, copyOfRange(1, size))
    return head
}

fun nextNode(node: Leetcode30DayChallenge8.ListNode?, values: IntArray) {
    if (values.isNotEmpty()) {
        node?.next = Leetcode30DayChallenge8.ListNode(values[0])
        nextNode(node?.next, values.copyOfRange(1, values.size))
    }
}

object Leetcode30DayChallenge8 {

    data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

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
