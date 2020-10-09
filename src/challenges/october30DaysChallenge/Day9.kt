package challenges.october30DaysChallenge

import utils.TreeNode
import utils.root
import kotlin.test.assertEquals


/**
 * Binary Search
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums.
 *
 * If target exists, then return its index, otherwise return -1.
 */
fun main(args: Array<String>) {
    val tree = root {
        value = 20
        left {
            value = 10
            left { value = 5 }
            right { value = 15 }
        }
        right { value = 30 }
    }
    val ser = Day9.Codec()
    val serializedTree: String = ser.serialize(tree)
    val ans = ser.deserialize(serializedTree)
    assertEquals(tree, ans)
}

object Day9 {

    class Codec {

        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            val list = mutableListOf<Int>()
            serializeRecursively(root, list)
            return list.joinToString(",")
        }

        private fun serializeRecursively(root: TreeNode?, list: MutableList<Int>) {
            if (root == null) list.add(-1)
            else {
                list.add(root.`val`)
                serializeRecursively(root.left, list)
                serializeRecursively(root.right, list)
            }
        }

        // Decodes your encoded data to tree.
        var deserializationCounter = 0

        fun deserialize(data: String): TreeNode? {
            deserializationCounter = 0
            val list = data.split(",").map { it.toInt() }
            if (list.firstOrNull() in listOf(null, -1)) return null
            return deserializeRecursively(list)
        }

        private fun deserializeRecursively(list: List<Int>): TreeNode {
            val node = TreeNode(list[deserializationCounter])
            deserializationCounter++
            if (list.getOrNull(deserializationCounter) != -1) {
                node.left = deserializeRecursively(list)
            } else {
                deserializationCounter++
            }
            if (list.getOrNull(deserializationCounter) != -1) {
                node.right = deserializeRecursively(list)
            } else {
                deserializationCounter++
            }
            return node
        }
    }
}