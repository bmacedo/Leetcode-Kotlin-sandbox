package biweeklyContest26

import utils.TreeNode
import utils.root

/**
 * Count Good Nodes in Binary Tree
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 */
fun main(args: Array<String>) {
    val input = root { value = 3
        left { value = 1
            left { value = 3 }
        }
        right { value = 4
            left { value = 1 }
            right { value = 5 }
        }
    }
    println(CountGoodNodesInBinaryTree.goodNodes(input))
}

object CountGoodNodesInBinaryTree {
    fun goodNodes(root: TreeNode?): Int {
        return countGoodNodesFrom(root, HashSet())
    }

    private fun countGoodNodesFrom(node: TreeNode?, seen: HashSet<Int>): Int {
        if (node == null) return 0
        val value = node.`val`

        val thisValue = if (seen.find { it > value } == null) {
            seen.add(value)
            1
        } else {
            0
        }

        val leftSeen = HashSet(seen)
        val rightSeen = HashSet(seen)
        return thisValue + countGoodNodesFrom(node.left, leftSeen) + countGoodNodesFrom(node.right, rightSeen)
    }
}