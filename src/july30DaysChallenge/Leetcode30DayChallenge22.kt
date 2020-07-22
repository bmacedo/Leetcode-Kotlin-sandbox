package july30DaysChallenge

import utils.TreeNode
import utils.root
import java.util.*
import kotlin.collections.HashMap


/**
 * Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 */
fun main(args: Array<String>) {
    val input = root {
        value = 3
        left {
            value = 9
            left { value = 2 }
            right { value = 5 }
        }
        right {
            value = 20
            left { value = 15 }
            right { value = 7 }
        }
    }

    println(Leetcode30DayChallenge22.zigzagLevelOrder(input))
}


object Leetcode30DayChallenge22 {

    // O(n)
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root != null) {
            val queue = ArrayDeque<TreeNode>().apply { add(root) }
            var isAddingLeftFirst = true

            while (queue.isNotEmpty()) {
                val size = queue.size
                val layer = mutableListOf<Int>()

                for (i in 0 until size) {
                    val node = queue.poll()

                    if (isAddingLeftFirst) layer.add(node.`val`) else layer.add(0, node.`val`)

                    node.left?.let { queue.add(it) }
                    node.right?.let { queue.add(it) }

                }

                isAddingLeftFirst = !isAddingLeftFirst
                result.add(layer)
            }
        }
        return result
    }

    // O(n (logn)ˆ2)
    fun zigzagLevelOrderSlow(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val hash = HashMap<Int, MutableList<Int>>()
        if (root != null) {
            dfs(hash, root, 0)
            // sorting: O(n log n)
            hash.keys.sorted().forEach { level ->
                val itemsOnLevel = hash[level] ?: mutableListOf()
                val orderedItems = if (level % 2 == 0) itemsOnLevel else itemsOnLevel.reversed() // O (log n)
                result.add(orderedItems)
            }
        }
        return result
    }

    private fun dfs(hash: HashMap<Int, MutableList<Int>>, node: TreeNode?, level: Int) {
        if (node != null) {
            hash[level] = hash.getOrDefault(level, mutableListOf()).apply { add(node.`val`) }
            dfs(hash, node.left, level + 1)
            dfs(hash, node.right, level + 1)
        }
    }
}
