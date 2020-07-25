package challenges.july30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
fun main(args: Array<String>) {
    val tree1 = root { value = 1; left { value = 3 }; right { value = 3 } }
    val tree2 = root { value = 1; left { value = 2 }; right { value = 3 } }
    println(Leetcode30DayChallenge13.isSameTree(tree1, tree2))
}


object Leetcode30DayChallenge13 {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return when {
            p == null && q == null -> true
            p?.`val` == q?.`val` -> isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
            else -> false
        }
    }
}
