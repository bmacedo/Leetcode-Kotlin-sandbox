package contests.biweeklyContest27

/**
 * Course Schedule IV
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have direct prerequisites, for example, to take course 0 you have first to
 * take course 1, which is expressed as a pair: [1,0]
 *
 * Given the total number of courses n, a list of direct prerequisite pairs and a list of queries pairs.
 *
 * You should answer for each queries[ i ] whether the course queries[i][0] is a prerequisite of the
 * course queries[i][1] or not.
 *
 * Return a list of boolean, the answers to the given queries.
 *
 * Please note that if course a is a prerequisite of course b and course b is a prerequisite of
 * course c, then, course a is a prerequisite of course c.
 */
fun main(args: Array<String>) {
    val n = 2
    val prerequisites = arrayOf(intArrayOf(1, 0))
    val queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
    println(CourseScheduleIV.checkIfPrerequisite(n, prerequisites, queries).toList())
}

object CourseScheduleIV {
    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val output = BooleanArray(queries.size) { false }

        val invAdjList = HashMap<Int, MutableSet<Int>>()
        prerequisites.forEach { (a, b) ->
            invAdjList[b] = invAdjList.getOrDefault(b, mutableSetOf()).apply { add(a) }
        }

        val pr = HashMap<Int, MutableSet<Int>>()
        invAdjList.forEach { (course, _) ->
            pr[course] = getPR(course, invAdjList, pr)
        }

        queries.forEachIndexed { index, (query, course) ->
            output[index] = pr[course]?.contains(query) ?: false
        }

        return output
    }

    private fun getPR(course: Int, invAdjList: HashMap<Int, MutableSet<Int>>, pr: HashMap<Int, MutableSet<Int>>): MutableSet<Int> {
        if (pr[course] != null) return pr[course]!!

        val output = mutableSetOf<Int>()
        val directPrereqs = invAdjList[course] ?: mutableSetOf()

        output.addAll(directPrereqs)
        directPrereqs.forEach { c ->
            val prC = getPR(c, invAdjList, pr)
            output += prC
        }
        pr[course] = output
        return output
    }
}