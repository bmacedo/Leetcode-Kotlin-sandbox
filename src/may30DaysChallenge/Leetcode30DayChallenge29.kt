package may30DaysChallenge


/**
 * Course Schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish
 * all courses?
 */
fun main(args: Array<String>) {
//    val numCourses = 4
//    val prerequisites = arrayOf(
//            intArrayOf(2,0),
//            intArrayOf(1,0),
//            intArrayOf(3,1),
//            intArrayOf(3,2),
//            intArrayOf(1,3)
//    )
    val numCourses = 8
    val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 6),
            intArrayOf(1, 7),
            intArrayOf(6, 4),
            intArrayOf(7, 0),
            intArrayOf(0, 5)
    )
    println(Leetcode30DayChallenge29.canFinish(numCourses, prerequisites))
}

object Leetcode30DayChallenge29 {

    private val checked = mutableSetOf<Int>()
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val invAdjList = HashMap<Int, MutableSet<Int>>()
        prerequisites.forEach { (a, b) ->
            invAdjList[b] = invAdjList.getOrDefault(b, mutableSetOf()).apply { add(a) }
        }
        for (num in 0 until numCourses) {
            val links = invAdjList[num] ?: mutableSetOf()
            for (link in links) {
                if (canReach(mutableSetOf(num), link, invAdjList)) return false
            }
        }
        return true
    }

    private fun canReach(targets: MutableSet<Int>, from: Int, invAdjList: HashMap<Int, MutableSet<Int>>): Boolean {
        if (checked.contains(from)) return false
        if (from in targets) return true
        targets.add(from)
        val links = invAdjList[from] ?: mutableSetOf()
        for (link in links) {
            if (canReach(targets, link, invAdjList)) return true
        }
        targets.remove(from)
        checked.add(from)
        return false
    }
}

