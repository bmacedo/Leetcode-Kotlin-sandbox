package july30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * Maximum Width of Binary Tree
 *
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most
 * non-null nodes in the level, where the null nodes between the end-nodes are also counted into the
 * length calculation).
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 1
        left {
            value = 3
            left { value = 5 }
            right { value = 3 }
        }
    }
    println(Leetcode30DayChallenge9.widthOfBinaryTree(tree))
}

object Leetcode30DayChallenge9 {

    private var maxWidth = 0
    private val map = HashMap<Int, Int>()

    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        maxWidth(root, 0, 0)
        return maxWidth
    }

    private fun maxWidth(root: TreeNode?, depth: Int, position: Int) {
        if (root == null) return

        map.computeIfAbsent(depth) { position }
        maxWidth = maxOf(maxWidth, position - map.getOrDefault(depth, 0) + 1)

        maxWidth(root.left, depth + 1, position * 2)
        maxWidth(root.right, depth + 1, position * 2 + 1)
    }
}
