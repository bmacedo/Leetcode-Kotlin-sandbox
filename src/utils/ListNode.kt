package utils

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun IntArray.toListNode(): ListNode {
    val head = ListNode(this[0])
    nextNode(head, copyOfRange(1, size))
    return head
}

fun ListNode?.println() {
    var currentNode = this
    val resultingList = mutableListOf<Int>()
    while (currentNode != null) {
        resultingList.add(currentNode.`val`)
        currentNode = currentNode.next
    }
    println(resultingList)
}

fun nextNode(node: ListNode?, values: IntArray) {
    if (values.isNotEmpty()) {
        node?.next = ListNode(values[0])
        nextNode(node?.next, values.copyOfRange(1, values.size))
    }
}