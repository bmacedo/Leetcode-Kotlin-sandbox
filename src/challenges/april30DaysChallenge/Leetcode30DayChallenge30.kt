package challenges.april30DaysChallenge

import utils.TreeNode
import utils.print
import utils.root


/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 *
 * Given a binary tree where each path going from the root to any leaf form a valid
 * sequence, check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the
 * concatenation of all values of the nodes along a path results in a sequence in the
 * given binary tree.
 *
 * Example:
 * Given a binary root
 *        0
 *      /  \
 *     1    0
 *    / \   /
 *   0  1  0
 *   \  /\
 *   1 0  0
 *
 *  Valid sequences: [0,1,0,1], [0,1,1,0], [0,0,0]
 */
fun main(args: Array<String>) {

    // expect path size of 42
    val tree = root { value = 0
        left { value = 1
            left {value = 0
                right { value = 1 }
            }
            right { value = 1
                left { value = 0 }
                right { value = 0 }
            }
        }
        right { value = 0
            left { value = 0 }
        }
    }
    tree.print()
    println(Leetcode30DayChallenge30.isValidSequence(tree, intArrayOf(0,0,1)))
}

object Leetcode30DayChallenge30 {

    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        if (arr.isEmpty()) return root != null
        return isValidSubsequence(root, 0, arr)
    }

    private fun isValidSubsequence(node: TreeNode?, i: Int, arr: IntArray): Boolean {
        if (i in arr.indices && node?.`val` == arr[i]) {
            return if (node.left == null && node.right == null) {
                (i == arr.lastIndex)
            } else if (node.left != null && node.right != null) {
                val path1 = isValidSubsequence(node.left, i + 1, arr)
                val path2 = isValidSubsequence(node.right, i + 1, arr)
                path1 || path2
            } else if (node.left != null) {
                isValidSubsequence(node.left, i+1, arr)
            } else {
                isValidSubsequence(node.right, i+1, arr)
            }
        }
        return false
    }
}
