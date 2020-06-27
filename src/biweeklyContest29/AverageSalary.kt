package biweeklyContest29

/**
 * Average Salary Excluding the Minimum and Maximum Salary
 *
 * Given an array of unique integers salary where salary[ i ] is the salary of the employee i.
 *
 * Return the average salary of employees excluding the minimum and maximum salary.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(6000, 5000, 4000, 3000, 2000, 1000)
    println(AverageSalary.average(input))
}

object AverageSalary {
    fun average(salary: IntArray): Double {
        salary.sort()
        return salary.drop(1).dropLast(1).average()
    }
}