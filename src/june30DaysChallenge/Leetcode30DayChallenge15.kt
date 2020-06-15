package june30DaysChallenge

import utils.TreeNode
import utils.print
import utils.root


/**
 * Search in a Binary Search Tree
 *
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 *
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 4
        left {
            value = 2
            left { value = 1 }
            right { value = 3 }
        }
        right { value = 7 }
    }
    val target = 8
    Leetcode30DayChallenge15.searchBST(tree, target)?.print()
}

object Leetcode30DayChallenge15 {

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null || root.`val` == `val`) return root
        return if (`val` < root.`val`) {
            searchBST(root.left, `val`)
        } else {
            searchBST(root.right, `val`)
        }
    }
}