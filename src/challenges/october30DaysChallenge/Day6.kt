package challenges.october30DaysChallenge

import utils.TreeNode
import utils.print
import utils.root


/**
 * Insert into a Binary Search Tree
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does
 * not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains
 * a BST after insertion. You can return any of them.
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
    Day6.insertIntoBST(tree, 5)?.print()
}

object Day6 {

    fun insertIntoBST(root: TreeNode?, value: Int): TreeNode? {
        val node = root ?: return TreeNode(value)
        if (value > node.`val`) {
            // try insert on right if null
            if (node.right == null) {
                val newNode = TreeNode(value)
                node.right = newNode
            } else {
                insertIntoBST(node.right, value)
            }
        } else {
            if (node.left == null) {
                val newNode = TreeNode(value)
                node.left = newNode
            } else {
                insertIntoBST(node.left, value)
            }
        }
        return node
    }
}