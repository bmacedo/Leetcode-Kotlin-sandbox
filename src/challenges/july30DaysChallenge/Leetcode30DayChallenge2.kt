package challenges.july30DaysChallenge

import utils.TreeNode
import utils.root
import java.util.*

/**
 * Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example: Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *   15   7
 *
 * Outputs:
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
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
    println(Leetcode30DayChallenge2.levelOrderBottom(tree))
}

object Leetcode30DayChallenge2 {


    // Uses a queue to run a breadth first search and
    // adds each level in the beginning of the list, resulting in a
    // reversed list
    // O(n)
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()

        if (root == null) return ans

        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            val level = ArrayList<Int>(size)

            for (i in 0 until size) {
                val node = queue.poll()
                level.add(node.`val`)
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            ans.add(0, level)
        }

        return ans
    }

    // O(n log n)
    fun levelOrderBottomSlow(root: TreeNode?): List<List<Int>> {
        val hash = TreeMap<Int, MutableList<Int>> { o1, o2 -> -o1.compareTo(o2) } // <Level, Values>
        dfs(hash, root, 0)
        return hash.map { it.value }
    }

    // O(n log n)
    private fun dfs(hashMap: TreeMap<Int, MutableList<Int>>, node: TreeNode?, level: Int) {
        if (node != null) {
            // O(log n)
            val currentLevelList = hashMap.getOrDefault(level, mutableListOf()).apply { add(node.`val`) }
            hashMap[level] = currentLevelList
            dfs(hashMap, node.left, level + 1)
            dfs(hashMap, node.right, level + 1)
        }
    }
}