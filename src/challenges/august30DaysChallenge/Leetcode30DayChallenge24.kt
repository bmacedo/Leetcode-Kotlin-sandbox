package challenges.august30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 3
        left { value = 9 }
        right {
            value = 20
            left { value = 15 }
            right { value = 7 }
        }
    }
    println(Leetcode30DayChallenge24.sumOfLeftLeaves(tree))
}

object Leetcode30DayChallenge24 {


    fun sumOfLeftLeaves(root: TreeNode?, toTheLeft: Boolean = false): Int {
        var result = 0
        if (root != null) {
            if (root.right == null && root.left == null && toTheLeft) {
                result += root.`val`
            }
            if (root.right != null) {
                result += sumOfLeftLeaves(root.right, false)
            }
            if (root.left != null) {
                result += sumOfLeftLeaves(root.left, true)
            }
        }
        return result
    }
}