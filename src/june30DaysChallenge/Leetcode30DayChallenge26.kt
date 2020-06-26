package june30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could
 * represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 */
fun main(args: Array<String>) {
    val input = root {
        value = 1
        left { value = 2 }
        right { value = 3 }
    }
    println(Leetcode30DayChallenge26.sumNumbers(input))
}

object Leetcode30DayChallenge26 {

    var sum = 0
    fun sumNumbers(root: TreeNode?): Int {
        root?.let { sumLeafs(it, it.`val`) }
        return sum
    }

    private fun sumLeafs(node: TreeNode?, currentNum: Int) {
        if (node == null) return
        if (node.isLeaf()) {
            sum += currentNum
        } else {
            val num = currentNum * 10
            node.left?.let { sumLeafs(it, num + it.`val`) }
            node.right?.let { sumLeafs(it, num + it.`val`) }
        }
    }

    private fun TreeNode.isLeaf() = right == null && left == null
}
