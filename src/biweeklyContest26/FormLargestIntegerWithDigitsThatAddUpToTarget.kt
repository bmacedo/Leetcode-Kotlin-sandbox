package biweeklyContest26

import kotlin.math.cos
import kotlin.math.max

/**
 * Form Largest Integer With Digits That Add up to Target
 *
 * Given an array of integers cost and an integer target.
 *
 * Return the maximum integer you can paint under the following rules:
 * -    The cost of painting a digit (i+1) is given by cost[ i ] (0 indexed).
 * -    The total cost used must be equal to target.
 * -    Integer does not have digits 0.
 *
 * Since the answer may be too large, return it as string.
 *
 * If there is no way to paint any integer given the condition, return "0".
 */
fun main(args: Array<String>) {
    val input = intArrayOf(4,3,2,5,6,7,2,5,5)
    val target = 9
    println(FormLargestIntegerWithDigitsThatAddUpToTarget.largestNumber(input, target))
}

// Unable to finish it in time
// Look for "Unbounded Knapsack" problem
object FormLargestIntegerWithDigitsThatAddUpToTarget {

    internal class Node(val cost: Int, val char: Char) {
        val links = mutableListOf<Node>()

        fun createLinks(costArr: IntArray, target: Int) {
            val max = target - cost

            costArr.filter { it <= max }.forEachIndexed { index, cost ->
                val childNode = Node(cost, "${index + 1}"[0])
                childNode.createLinks(costArr, max - cost)
                links.add(childNode)
            }
        }
    }

    fun largestNumber(costArr: IntArray, target: Int): String {
        val possibleRoots = mutableListOf<Node>()

        // create all possible routes
        costArr.filter { it <= target }.forEachIndexed { index, cost ->
            val rootNode = Node(cost, "${index+1}"[0])
            rootNode.createLinks(costArr, target - cost)
            possibleRoots.add(rootNode)
        }

        // find the routes with max depth (could result in more than one)
        val filteredPossibleRoots = findMaxDepth(possibleRoots)

        // if no route left, return "0"
        if (filteredPossibleRoots.isEmpty()) return "0"

        // select the route that contains the largest numbers in the beginning
        // traverse and return the result as string


        // return the string
        TODO()
    }

    private fun findMaxDepth(possibleRoots: MutableList<Node>): List<Node> {
        val depths = possibleRoots.map { it to findDepth(it) }
        val maxDepth = depths.map { it.second }.max()
        return depths.filter { it.second == maxDepth }.map { it.first }
    }

    private fun findDepth(node: Node): Int {
        var maxDepth = 0
        node.links.forEach { childNode ->
            val childDepth = findDepth(childNode)
            if (childDepth > maxDepth) {
                maxDepth = childDepth
            }
        }
        return 1 + maxDepth
    }
}