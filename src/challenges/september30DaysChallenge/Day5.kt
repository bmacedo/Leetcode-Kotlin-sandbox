package challenges.september30DaysChallenge

import utils.TreeNode
import utils.root


/**
 * All Elements in Two Binary Search Trees
 *
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 */
fun main(args: Array<String>) {
    val tree1 = root {
        value = 2
        left { value = 1 }
        right { value = 4 }
    }

    val tree2 = root {
        value = 1
        left { value = 0 }
        right { value = 3 }
    }

    println(Day5.getAllElements(tree1, tree2))
}

object Day5 {

    // O(n + m) time, O(n + m) space
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val list1 = root1.traverseBST()
        val list2 = root2.traverseBST()

        val result = mutableListOf<Int>()

        var i = 0
        var j = 0

        while (i < list1.size || j < list2.size) {
            if (i in list1.indices && j in list2.indices) {
                when {
                    list1[i] < list2[j] -> {
                        result.add(list1[i])
                        i++
                    }
                    list1[i] > list2[j] -> {
                        result.add(list2[j])
                        j++
                    }
                    else -> {
                        result.add(list1[i])
                        result.add(list2[j])
                        i++
                        j++
                    }
                }
            } else if (i in list1.indices) {
                result.add(list1[i])
                i++
            } else {
                result.add(list2[j])
                j++
            }
        }

        return result
    }

    private fun TreeNode?.traverseBST(): List<Int> {
        return this?.let { node ->
            mutableListOf<Int>().apply {
                // go to leftmost node. add it.
                // then go to right node and then go to the leftmost node. add it.
                addAll(node.left.traverseBST())
                add(node.`val`)
                addAll(node.right.traverseBST())
            }
        } ?: emptyList()
    }
}


