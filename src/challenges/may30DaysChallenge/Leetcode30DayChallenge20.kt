package challenges.may30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up: What if the BST is modified (insert/delete operations) often and you need to find the
 * kth smallest frequently? How would you optimize the kthSmallest routine?
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 5
        left {
            value = 3
            left {
                value = 2
                left { value = 1 }
            }
            right { value = 4 }
        }
        right { value = 6 }
    }

    val k = 3

    // expect: 3
    println(Leetcode30DayChallenge20.kthSmallest(tree, k))
}

object Leetcode30DayChallenge20 {

    val list = mutableListOf<Int>()

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        dfs(root, k)
        return list.lastOrNull() ?: -1
    }

    private fun dfs(node: TreeNode?, k: Int) {
        if (node == null) return
        node.left?.let { dfs(it, k) }
        if (list.size < k) {
            list.add(node.`val`)
            node.right?.let { dfs(it, k) }
        }
    }
}

