package may30DaysChallenge

import utils.TreeNode
import utils.root

/**
 * Cousins in Binary Tree
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different
 * nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 1
        left {
            value = 2
            right { value = 4 }
        }
        right { value = 3
            right { value = 5 }
        }
    }
    println(Leetcode30DayChallenge7.isCousins(tree, 4, 5))
}

object Leetcode30DayChallenge7 {

    data class Result(val parent: TreeNode, val value: Int)

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val hash = HashMap<Int, HashSet<Result>>()
        dfs(root, hash, 0)
        hash.forEach { (_, values) ->
            val xResult = values.find { it.value == x }
            val yResult = values.find { it.value == y }
            if (xResult != null && yResult != null && xResult.parent != yResult.parent) {
                return true
            }
        }
        return false
    }

    private fun dfs(node: TreeNode?, hash: HashMap<Int, HashSet<Result>>, depth: Int) {
        if (node != null) {
            node.left?.let { traverse(node, hash, depth, it) }
            node.right?.let { traverse(node, hash, depth, it) }
        }
    }

    private fun traverse(parent: TreeNode, hash: HashMap<Int, HashSet<Result>>, depth: Int, node: TreeNode) {
        hash[depth] = hash.getOrDefault(depth, HashSet()).apply { add(Result(parent, node.`val`)) }
        dfs(node, hash, depth + 1)
    }
}


