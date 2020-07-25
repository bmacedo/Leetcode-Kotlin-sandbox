package challenges.april30DaysChallenge

import utils.TreeNode
import utils.print
import utils.root


/**
 * Diameter of Binary Tree
 *
 * Given a binary root, you need to compute the length of the diameter of the root.
 * The diameter of a binary root is the length of the longest path between any two
 * nodes in a root. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary root
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 *
 *  Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 *  Note: The length of path between two nodes is represented by the number of edges between them.
 */
fun main(args: Array<String>) {

    // expect path size of 5 ( 4 -> 3 -> 2 -> 5 -> 6 -> 7
    val tree = root {
        value = 1
        left {
            value = 2
            left {
                value = 3
                left {
                    value = 4
                }
            }
            right {
                value = 5
                left {
                    value = 6
                    left {
                        value = 7
                    }
                }
            }
        }
    }
    tree.print()
    println(Leetcode30DayChallenge11.diameterOfBinaryTree(tree))
}

object Leetcode30DayChallenge11 {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val list = mutableSetOf<Int>()
        traverse(root, list)
        return list.max() ?: 0
    }

    private fun traverse(currentNode: TreeNode?, pathPossibilities: MutableSet<Int>): Int {
        when {
            currentNode?.left != null && currentNode.right != null -> {
                val path1 = 1 + traverse(currentNode.left, pathPossibilities)
                val path2 = 1 + traverse(currentNode.right, pathPossibilities)
                pathPossibilities.addAll(listOf(path1, path2, path1 + path2))
                return Math.max(path1, path2)
            }
            currentNode?.left != null -> {
                val path1 = 1 + traverse(currentNode.left, pathPossibilities)
                pathPossibilities.add(path1)
                return path1
            }
            currentNode?.right != null -> {
                val path2 = 1 + traverse(currentNode.right, pathPossibilities)
                pathPossibilities.add(path2)
                return path2
            }
            else -> return 0
        }
    }
}
