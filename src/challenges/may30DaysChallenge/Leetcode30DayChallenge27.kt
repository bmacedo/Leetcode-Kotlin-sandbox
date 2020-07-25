package challenges.may30DaysChallenge

import utils.asIntMatrix
import java.util.*
import kotlin.collections.HashMap


/**
 * Possible Bipartition
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups
 * of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[ i ] = [a, b], it means it is not allowed to put the people numbered a and b
 * into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 * Note:
 * -    1 <= N <= 2000
 * -    0 <= dislikes.length <= 10000
 * -    1 <= dislikes[ i ][ j ] <= N
 * -    dislikes[i][0] < dislikes[i][1]
 * -    There does not exist i != j for which dislikes[ i ] == dislikes[ j ].
 *
 */
fun main(args: Array<String>) {
    // expect true
    val N = 50
    val dislikes = """
    [21,47],
    [4,41],
    [2,41],
    [36,42],
    [32,45],
    [26,28],
    [32,44],
    [5,41],
    [29,44],
    [10,46],
    [1,6],
    [7,42],
    [46,49],
    [17,46],
    [32,35],
    [11,48],
    [37,48],
    [37,43],
    [8,41],
    [16,22],
    [41,43],
    [11,27],
    [22,44],
    [22,28],
    [18,37],
    [5,11],
    [18,46],
    [22,48],
    [1,17],
    [2,32],
    [21,37],
    [7,22],
    [23,41],
    [30,39],
    [6,41],
    [10,22],
    [36,41],
    [22,25],
    [1,12],
    [2,11],
    [45,46],
    [2,22],
    [1,38],
    [47,50],
    [11,15],
    [2,37],
    [1,43],
    [30,45],
    [4,32],
    [28,37],
    [1,21],
    [23,37],
    [5,37],
    [29,40],
    [6,42],
    [3,11],
    [40,42],
    [26,49],
    [41,50],
    [13,41],
    [20,47],
    [15,26],
    [47,49],
    [5,30],
    [4,42],
    [10,30],
    [6,29],
    [20,42],
    [4,37],
    [28,42],
    [1,16],
    [8,32],
    [16,29],
    [31,47],
    [15,47],
    [1,5],
    [7,37],
    [14,47],
    [30,48],
    [1,10],
    [26,43],
    [15,46],
    [42,45],
    [18,42],
    [25,42],
    [38,41],
    [32,39],
    [6,30],
    [29,33],
    [34,37],
    [26,38],
    [3,22],
    [18,47],
    [42,48],
    [22,49],
    [26,34],
    [22,36],
    [29,36],
    [11,25],
    [41,44],
    [6,46],
    [13,22],
    [11,16],
    [10,37],
    [42,43],
    [12,32],
    [1,48],
    [26,40],
    [22,50],
    [17,26],
    [4,22],
    [11,14],
    [26,39],
    [7,11],
    [23,26],
    [1,20],
    [32,33],
    [30,33],
    [1,25],
    [2,30],
    [2,46],
    [26,45],
    [47,48],
    [5,29],
    [3,37],
    [22,34],
    [20,22],
    [9,47],
    [1,4],
    [36,46],
    [30,49],
    [1,9],
    [3,26],
    [25,41],
    [14,29],
    [1,35],
    [23,42],
    [21,32],
    [24,46],
    [3,32],
    [9,42],
    [33,37],
    [7,30],
    [29,45],
    [27,30],
    [1,7],
    [33,42],
    [17,47],
    [12,47],
    [19,41],
    [3,42],
    [24,26],
    [20,29],
    [11,23],
    [22,40],
    [9,37],
    [31,32],
    [23,46],
    [11,38],
    [27,29],
    [17,37],
    [23,30],
    [14,42],
    [28,30],
    [29,31],
    [1,8],
    [1,36],
    [42,50],
    [21,41],
    [11,18],
    [39,41],
    [32,34],
    [6,37],
    [30,38],
    [21,46],
    [16,37],
    [22,24],
    [17,32],
    [23,29],
    [3,30],
    [8,30],
    [41,48],
    [1,39],
    [8,47],
    [30,44],
    [9,46],
    [22,45],
    [7,26],
    [35,42],
    [1,27],
    [17,30],
    [20,46],
    [18,29],
    [3,29],
    [4,30],
    [3,46]
        """.trimIndent().asIntMatrix()
    // expect false
    val N2 = 3
    val dislikes2 = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3)
    )
    // expect false
    val N3 = 5
    val dislikes3 = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(3, 5)
    )
    println(Leetcode30DayChallenge27.possibleBipartition(N, dislikes))
}

object Leetcode30DayChallenge27 {

    private val adjList = HashMap<Int, HashSet<Int>>()
    private val groups = HashMap<Int, Int>()

    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        // create adjList
        dislikes.forEach { (num1, num2) ->
            adjList[num1] = adjList.getOrDefault(num1, HashSet()).apply { add(num2) }
            adjList[num2] = adjList.getOrDefault(num2, HashSet()).apply { add(num1) }
        }

        // go through each node, to account for disjoint graphs
        for (num in 1..N) {
            // If the graph is connected, by visiting the first, all the others will be connected
            // recursively, so #isPossibleBipartition will be called only once here.
            // Otherwise, it will be called once for each disjoint graph.
            // Since it's disjoint, it's safe to start it with a given (random) label (in this case: 0)
            if (!groups.contains(num) && !isPossibleBipartition(num, 0)) {
                return false
            }
        }
        return true
    }

    private fun isPossibleBipartition(num: Int, group: Int): Boolean {
        if (groups.contains(num)) {
            // If the node was already visited, we already assigned a group to it.
            // IF we're trying to reassign the same group to it, it's a possible bipartition
            // Otherwise, if the new group we're trying to reassign is different, we have a conflict
            // and thus it's not a valid bipartition.
            return groups[num] == group
        }
        groups[num] = group

        var result = true
        adjList[num]?.forEach { numDislike ->
            if (!groups.contains(numDislike)) {
                // If it's a node that we haven't visited yet, we must visit while trying to assign
                // a different group from the current [num], since num and numDislike should not be
                // in the same group.
                // Using a mod operation here makes sure that there will be only groups 0 and 1.
                // The result should be true for every numDislike in the adjList. Otherwise return false.
                result = result && isPossibleBipartition(numDislike, (group + 1) % 2)
            }
            if (groups[numDislike] == groups[num]) {
                // If we find out that the numDislike actually belongs to the same group as num
                // this is not a possible bipartition and there's no need to continue.
                return false
            }
        }
        return result
    }

    // Failed solution that I originally tried
    fun possibleBipartitionFails(N: Int, dislikes: Array<IntArray>): Boolean {
        val hash = HashMap<Int, HashSet<Int>>()

        // O(n), n = amount of dislike pairs
        dislikes.forEach { (num1, num2) ->
            hash[num1] = hash.getOrDefault(num1, HashSet()).apply { add(num2) }
            hash[num2] = hash.getOrDefault(num2, HashSet()).apply { add(num1) }
        }

        val a = mutableSetOf<Int>()
        val b = mutableSetOf<Int>()

        // O(N)
        for (num in 1..N) {
            val numDislikes = hash[num]
            if (!hasAny(numDislikes, a)) {
                a.add(num)
            } else if (!hasAny(numDislikes, b)) {
                b.add(num)
            } else {
                return false
            }
        }
        return true
    }

    // O(m), m = amount of dislikes for a particular number. Worst case O(m) = O(n)
    private fun hasAny(numDislikes: HashSet<Int>?, a: MutableSet<Int>): Boolean {
        numDislikes?.forEach {
            if (a.contains(it)) return true
        }
        return false
    }
}

