package biweeklyContest29

/**
 * Parallel Courses II
 *
 * Given the integer n representing the number of courses at some university labeled from 1 to n,
 * and the array dependencies where dependencies[i] = [xi, yi]  represents a prerequisite relationship,
 * that is, the course xi must be taken before the course yi.
 *
 * Also, you are given the integer k.
 *
 * In one semester you can take at most k courses as long as you have taken all the prerequisites for
 * the courses you are taking.
 *
 * Return the minimum number of semesters to take all courses.
 *
 * It is guaranteed that you can take all courses in some way.
 */
fun main(args: Array<String>) {
    val n = 5
    val dependencies = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(4, 1),
            intArrayOf(1, 5))
    val k = 2
    println(ParallelCoursesII.minNumberOfSemesters(n, dependencies, k))
}

object ParallelCoursesII {
    fun minNumberOfSemesters(n: Int, dependencies: Array<IntArray>, k: Int): Int {
        TODO()
    }
}