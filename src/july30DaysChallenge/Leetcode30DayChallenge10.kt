package july30DaysChallenge


/**
 * Flatten a Multilevel Doubly Linked List
 *
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 *
 * These child lists may have one or more children of their own, and so on, to produce a multilevel
 * data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * You are given the head of the first level of the list.
 */
fun main(args: Array<String>) {
    val root = Node(1).withChild(Node(3)) doubleLinkedTo Node(2)
    println(Leetcode30DayChallenge10.flatten(root)?.string())
}

class Node(var `val`: Int) {

    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null

    infix fun doubleLinkedTo(node2: Node): Node {
        this.next = node2
        node2.prev = this
        return this
    }

    fun withChild(child: Node): Node {
        this.child = child
        return this
    }

    fun string(): String {
        var node = this
        var str = node.`val`.toString()
        while (node.next != null) {
            str += " -> ${node.next?.`val`}"
            node = node.next ?: break
        }
        return str
    }
}

object Leetcode30DayChallenge10 {

    fun flatten(root: Node?): Node? {
        flattenLevel(root, null)
        return root
    }

    private fun flattenLevel(root: Node?, returnTo: Node?) {
        var node = root ?: return
        var current: Node? = node
        while (current != null) {
            if (current.child != null) {
                val temp = current.next
                current.next = current.child
                current.child = null
                current.next?.prev = current
                flattenLevel(current, temp)
            }
            node = current
            current = node.next
        }

        node.next = returnTo
        returnTo?.prev = node
    }
}
