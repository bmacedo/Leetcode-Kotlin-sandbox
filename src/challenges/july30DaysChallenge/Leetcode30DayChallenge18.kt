package challenges.july30DaysChallenge


/**
 * Course Schedule II
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
 * you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them.
 *
 * If it is impossible to finish all courses, return an empty array.
 */
fun main(args: Array<String>) {
    val edges = arrayOf(
            intArrayOf(1, 0), // [1,0],
            intArrayOf(2, 0), // [2,0],
            intArrayOf(3, 1), // [3,1],
            intArrayOf(3, 2) // [3,2]
    )
    val n = 4
    println(Leetcode30DayChallenge18.findOrder(n, edges).toList())
}


object Leetcode30DayChallenge18 {

    // Slow. O(n square)
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val preReqs = HashMap<Int, MutableSet<Int>>() //

        val answer = mutableListOf<Int>()
        prerequisites.forEach { (courseToTake, prereq) ->
            preReqs[courseToTake] = preReqs.getOrDefault(courseToTake, mutableSetOf()).apply { add(prereq) }
        }

        for (i in 0 until numCourses) {
            if (!answer.contains(i)) answer.add(i)
            if (!addPreReqs(answer, preReqs, i)) return IntArray(0) // empty array
        }

        return answer.toIntArray()
    }

    private fun addPreReqs(answer: MutableList<Int>, preReqs: HashMap<Int, MutableSet<Int>>, course: Int): Boolean {
        val prerequisites = preReqs.getOrDefault(course, mutableSetOf())

        prerequisites.forEach { preCourse ->
            val indexOfParent = answer.indexOf(course)
            if (answer.contains(preCourse) && answer.indexOf(preCourse) > indexOfParent) {
                return false
            } else {
                if (!answer.contains(preCourse)) answer.add(indexOfParent, preCourse)
                if (!addPreReqs(answer, preReqs, preCourse)) return false
            }
        }
        return true
    }
}
