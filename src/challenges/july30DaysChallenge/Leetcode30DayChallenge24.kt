package challenges.july30DaysChallenge


/**
 * All Paths From Source to Target
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1,
 * and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes
 * j for which the edge (i, j) exists.
 */
fun main(args: Array<String>) {
    val input = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3),
            intArrayOf(3),
            intArrayOf()
    )

    println(Leetcode30DayChallenge24.allPathsSourceTarget(input))
}


object Leetcode30DayChallenge24 {

    fun allPathsSourceTarget(graph: Array<IntArray>, i: Int = 0): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val possibleFirstStep = graph[i].map { Pair(i, it) }
        possibleFirstStep.forEach { firstStep ->
            val (from, to) = firstStep
            val pathsFromNextStep = allPathsSourceTarget(graph, to)
            if (pathsFromNextStep.isEmpty()) {
                result.add(listOf(from, to))
            } else {
                pathsFromNextStep.forEach { path ->
                    if (i != 0 || path.contains(graph.lastIndex)) result.add(listOf(from) + path)
                }
            }
        }
        return result
    }
}
