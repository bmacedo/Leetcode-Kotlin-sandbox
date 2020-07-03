package july30DaysChallenge

/**
 * Prison Cells After N Days
 *
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * - If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * - Otherwise, it becomes vacant.
 *
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following way:
 * - cells[ i ] == 1 if the i-th cell is occupied,
 * - else cells[ i ] == 0.
 *
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 */
fun main(args: Array<String>) {
    val cells = intArrayOf(1, 1, 0, 1, 1, 0, 0, 0)
    val n = 1
    println(Leetcode30DayChallenge3.prisonAfterNDays(cells, n).toList())
}

object Leetcode30DayChallenge3 {

    // The trick: there's a cycle every 14 iterations
    fun prisonAfterNDays(cells: IntArray, n: Int): IntArray {
        var remainingIterations = if (n % 14 == 0) 14 else n % 14
        val result = IntArray(cells.size)
        while (remainingIterations > 0) {
            for (i in 1 until cells.lastIndex) {
                result[i] = if (cells[i - 1] == cells[i + 1]) 1 else 0
            }
            for (i in cells.indices) cells[i] = result[i]
            remainingIterations--
        }
        return result
    }
}