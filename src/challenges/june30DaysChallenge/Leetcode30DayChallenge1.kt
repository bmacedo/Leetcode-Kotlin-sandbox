package challenges.june30DaysChallenge

import utils.TreeNode
import utils.print
import utils.root

/**
 * Invert Binary Tree
 *
 * Example input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Outputs:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 4
        left {
            value = 2
            left { value = 1 }
            right { value = 3 }
        }
        right {
            value = 7
            left { value = 6 }
            right { value = 9 }
        }
    }
    Leetcode30DayChallenge1.invertTree(tree)?.print()
}

object Leetcode30DayChallenge1 {
    fun invertTree(root: TreeNode?): TreeNode? {
        dfs(root)
        return root
    }

    private fun dfs(node: TreeNode?) {
        if (node != null) {
            val left = node.left
            val right = node.right
            node.left = right
            node.right = left
            dfs(node.left)
            dfs(node.right)
        }
    }
}