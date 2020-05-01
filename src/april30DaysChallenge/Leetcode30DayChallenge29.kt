package april30DaysChallenge

import utils.TreeNode
import utils.print
import utils.root


/**
 * Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 *
 * The path must contain at least one node and does not need to go through the root.
 *
 *
 * Given a binary root, you need to compute the length of the diameter of the root.
 * The diameter of a binary root is the length of the longest path between any two
 * nodes in a root. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary root
 *       -10
 *       / \
 *      9  20
 *        / \
 *       15  7
 *
 *  Return 42, which is the sum of the path [15, 20, 7].
 */
fun main(args: Array<String>) {

    // expect path size of 42
    val tree = root { value = -10
        left { value = 9 }
        right { value = 20
            left { value = 15 }
            right { value = 7 }
        }
    }
    tree.print()
    println(Leetcode30DayChallenge29.maxPathSum(tree))
}

object Leetcode30DayChallenge29 {

    fun maxPathSum(root: TreeNode?): Int {
        val list = mutableSetOf<Int>()
        traverse(root, list)
        return list.max() ?: 0
    }

    private fun traverse(currentNode: TreeNode?, pathPossibilities: MutableSet<Int>): Int {
        val path0 = currentNode?.`val` ?: 0
        pathPossibilities.add(path0)
        when {
            currentNode?.left != null && currentNode.right != null -> {
                val path1 = currentNode.`val` + traverse(currentNode.left, pathPossibilities)
                val path2 = currentNode.`val` + traverse(currentNode.right, pathPossibilities)
                pathPossibilities.addAll(listOf(path1, path2, path1 + path2 - path0))
                return Math.max(path0, Math.max(path1, path2))
            }
            currentNode?.left != null -> {
                val path1 = currentNode.`val` + traverse(currentNode.left, pathPossibilities)
                pathPossibilities.add(path1)
                return Math.max(path0, path1)
            }
            currentNode?.right != null -> {
                val path2 = currentNode.`val` + traverse(currentNode.right, pathPossibilities)
                pathPossibilities.add(path2)
                return Math.max(path0, path2)
            }
            currentNode != null -> {
                return currentNode.`val`
            }
        }
        return 0
    }
}
