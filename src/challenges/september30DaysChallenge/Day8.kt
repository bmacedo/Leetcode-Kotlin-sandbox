package challenges.september30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * Sum of Root To Leaf Binary Numbers
 *
 * Given a binary tree, each node has value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 1
        left {
            value = 0
            left { value = 0 }
            right { value = 1 }
        }
        right {
            value = 1
            left { value = 0 }
            right { value = 1 }
        }
    }
    println(Day8.sumRootToLeaf(tree))
}

object Day8 {

    private val results = mutableListOf<Int>()

    // O(n) time, O(n) space
    fun sumRootToLeaf(root: TreeNode?): Int {
        fillResults(root, mutableListOf())
        return results.sum()
    }

    private fun fillResults(node: TreeNode?, digits: MutableList<Int>) {
        if (node == null) return

        digits.add(node.`val`)
        if (node.left == null && node.right == null) {
            results.add(Integer.valueOf(digits.joinToString(""), 2))
        } else {
            fillResults(node.left, digits)
            fillResults(node.right, digits)
        }
        digits.removeAt(digits.lastIndex)
    }
}


