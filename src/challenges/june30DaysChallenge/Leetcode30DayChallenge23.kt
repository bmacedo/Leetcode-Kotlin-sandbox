package challenges.june30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2^h
 * nodes inclusive at the last level h.
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 1
        left {
            value = 2
            left { value = 4 }
            right { value = 5 }
        }
        right {
            value = 3
            left { value = 6 }
        }
    }
    println(Leetcode30DayChallenge23.countNodes(tree))
}

object Leetcode30DayChallenge23 {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val height = heightLeft(root)
        val heightRight = heightRight(root)

        if (height == heightRight) {
            return (1 shl height) - 1
        }
        return 1 + countNodes(root.left) + countNodes(root.right)
    }

    private fun heightLeft(root: TreeNode?): Int {
        var h = 0
        var curr = root
        while (curr != null) {
            curr = curr.left
            h++
        }
        return h
    }

    private fun heightRight(root: TreeNode?): Int {
        var h = 0
        var curr = root
        while (curr != null) {
            curr = curr.right
            h++
        }
        return h
    }
}
