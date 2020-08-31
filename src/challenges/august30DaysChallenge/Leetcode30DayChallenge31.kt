package challenges.august30DaysChallenge

import utils.TreeNode
import utils.print
import utils.root


/**
 * Delete Node in a BST
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 * - Search for a node to remove.
 * - If the node is found, delete the node
 *
 * Note: Time complexity should be O(height of tree).
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 5
        left {
            value = 3
            left { value = 2 }
            right { value = 4 }
        }
        right {
            value = 6
            right { value = 7 }
        }
    }
    Leetcode30DayChallenge31.deleteNode(tree, 3)?.print()
}

object Leetcode30DayChallenge31 {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        fun successor(root: TreeNode): Int = root.left?.let { successor(it) } ?: root.`val`

        if (root == null) return root
        when {
            root.`val` > key -> root.left = deleteNode(root.left, key)
            root.`val` < key -> root.right = deleteNode(root.right, key)
            else -> {
                if (root.left == null) {
                    return root.right
                } else if (root.right == null) {
                    return root.left
                }
                root.`val` = successor(root.right!!)
                root.right = deleteNode(root.right, root.`val`)
            }
        }
        return root
    }

}