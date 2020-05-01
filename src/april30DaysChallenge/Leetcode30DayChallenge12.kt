package april30DaysChallenge


/**
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.
 * The result of this smash is:
 *  -   If x == y, both stones are totally destroyed;
 *  -   If x != y, the stone of weight x is totally destroyed, and the stone
 *  of weight y has new weight y-x.
 *
 *  At the end, there is at most 1 stone left.
 *  Return the weight of this stone (or 0 if there are no stones left.)
 */
fun main(args: Array<String>) {
    val input = intArrayOf(2,7,4,1,8,1)
    println(Leetcode30DayChallenge12.lastStoneWeight(input))
}

object Leetcode30DayChallenge12 {

    fun lastStoneWeight(stones: IntArray): Int {
        val currentStones = stones.sortedDescending().toMutableList()
        while (currentStones.size > 1) {
            val smashResult = smash(currentStones[0], currentStones[1])
            currentStones.removeAt(0)
            currentStones.removeAt(0)
            if (smashResult != 0) {
                currentStones.add(smashResult)
                currentStones.sortDescending()
            }
        }
        return if (currentStones.isEmpty()) 0 else currentStones[0]
    }

    private fun smash(largeStone: Int, smallerStone: Int): Int {
        if (largeStone == smallerStone) return 0
        return largeStone - smallerStone
    }
}
