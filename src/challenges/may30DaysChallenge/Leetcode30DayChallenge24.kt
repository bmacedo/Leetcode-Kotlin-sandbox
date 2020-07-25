package challenges.may30DaysChallenge

import utils.TreeNode
import utils.print


/**
 * Construct Binary Search Tree from Preorder Traversal
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of
 * node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses
 * node.left, then traverses node.right.)
 *
 * It's guaranteed that for the given test cases there is always possible to find a binary search
 * tree with the given requirements.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(8, 5, 1, 7, 10, 12)
    Leetcode30DayChallenge24.bstFromPreorder(input)?.print()
}

object Leetcode30DayChallenge24 {

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null

        val root = TreeNode(preorder[0])
        var currentNode = root
        for (i in 1 until preorder.size) {
            val value = preorder[i]
            currentNode = findClosestNode(value, currentNode)
            if (value < currentNode.`val`) {
                currentNode.left = TreeNode(value)
            } else if (value > currentNode.`val`) {
                currentNode.right = TreeNode(value)
            }
            currentNode = root
        }
        return root
    }

    private fun findClosestNode(value: Int, currentNode: TreeNode): TreeNode {
        var result = currentNode
        if (value < currentNode.`val` && currentNode.left != null) {
            result = findClosestNode(value, currentNode.left!!)
        } else if (value > currentNode.`val` && currentNode.right != null) {
            result = findClosestNode(value, currentNode.right!!)
        }
        return result
    }
}

