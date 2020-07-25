package challenges.april30DaysChallenge

import utils.TreeNode
import utils.print


/**
 * Construct Binary Search Tree from Preorder Traversal
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant
 * of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses
 * node.left, then traverses node.right.)
 */
fun main(args: Array<String>) {
    val input = intArrayOf(8, 5, 1, 7, 10, 12) // expect: [8,5,10,1,7,null,12]
//    val input = intArrayOf(1,3,2) // expect: [1,null,3,2]

    Leetcode30DayChallenge20.bstFromPreorder(input)?.print()
}

object Leetcode30DayChallenge20 {

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null
        val rootNode = TreeNode(preorder[0])
        var currentNode = rootNode
        var i = 1
        while (i < preorder.size) {
            val value = preorder[i]
            while (value < currentNode.`val`) {
                if (currentNode.left == null) {
                    currentNode.left = TreeNode(value)
                    i++
                    currentNode = rootNode
                    break
                } else {
                    currentNode = currentNode.left!!
                }
            }
            while (value > currentNode.`val`) {
                if (currentNode.right == null) {
                    currentNode.right = TreeNode(value)
                    i++
                    currentNode = rootNode
                    break
                } else {
                    currentNode = currentNode.right!!
                }
            }
        }

        return rootNode
    }
}
