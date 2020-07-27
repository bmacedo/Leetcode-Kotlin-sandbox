package challenges.july30DaysChallenge

import utils.TreeNode
import utils.print


/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note: You may assume that duplicates do not exist in the tree.
 */
fun main(args: Array<String>) {
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    val postorder = intArrayOf(9, 15, 7, 20, 3)

    Leetcode30DayChallenge27.buildTree(inorder, postorder)?.print()
}


object Leetcode30DayChallenge27 {


    private data class Index(var index: Int = 0)

    fun buildTree(inOrder: IntArray, postOrder: IntArray): TreeNode? {
        return buildUtil(inOrder, postOrder, 0, inOrder.lastIndex, Index(inOrder.lastIndex))
    }

    private fun buildUtil(inOrder: IntArray, post: IntArray, inStart: Int,
                          inEnd: Int, pIndex: Index): TreeNode? {
        // Base case
        if (inStart > inEnd)
            return null

        /* Pick current node from Postrder traversal using
           postIndex and decrement postIndex */
        val node = TreeNode(post[pIndex.index])
        pIndex.index--

        /* If this node has no children then return */
        if (inStart == inEnd)
            return node

        /* Else find the index of this node inOrder Inorder
           traversal */
        val iIndex = search(inOrder, inStart, inEnd, node.`val`)

        /* Using index inOrder Inorder traversal, construct left and
           right subtress */
        node.right = buildUtil(inOrder, post, iIndex + 1, inEnd, pIndex)
        node.left = buildUtil(inOrder, post, inStart, iIndex - 1, pIndex)

        return node
    }

    /* Function to find index of value in arr[start...end]
       The function assumes that value is postsent in in[] */
    fun search(arr: IntArray, start: Int, end: Int, value: Int): Int {
        var i: Int = start
        while (i <= end) {
            if (arr[i] == value)
                break
            i++
        }
        return i
    }
}
