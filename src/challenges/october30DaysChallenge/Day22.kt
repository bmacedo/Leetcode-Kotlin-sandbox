package challenges.october30DaysChallenge

import utils.TreeNode
import utils.root
import java.util.*

/**
 * Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 3
        left { value = 9 }
        right {
            value = 20
            left { value = 15 }
            right { value = 7 }
        }
    }
    println(Day22.minDepth(tree))
}

object Day22 {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val list = ArrayDeque<Pair<TreeNode, Int>>()
        list.add(Pair(root, 1))
        while (list.isNotEmpty()) {
            val (node, level) = list.poll()
            if (node.left == null && node.right == null) return level

            node.left?.let { list.add(Pair(it, level + 1)) }
            node.right?.let { list.add(Pair(it, level + 1)) }
        }
        return 0
    }
}