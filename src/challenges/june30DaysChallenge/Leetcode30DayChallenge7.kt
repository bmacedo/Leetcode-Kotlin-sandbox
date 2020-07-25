package challenges.june30DaysChallenge

/**
 * Coin Change 2
 *
 * You are given coins of different denominations and a total amount of money.
 *
 * Write a function to compute the number of combinations that make up that amount.
 *
 * You may assume that you have infinite number of each kind of coin.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 5)
    val amount = 40
    println(Leetcode30DayChallenge7.change(amount, input))
}

object Leetcode30DayChallenge7 {

    // O(amount * sizeOf(coins))
    // Iterative bottom-up approach. Accepted.
    fun change(amount: Int, coins: IntArray): Int {
        val n = coins.size
        val hash = Array(n + 1) { IntArray(amount + 1) { 0 } }
        // Base case: If the target is zero and you have zero coins, there's `1` way of doing it: []
        hash[0][0] = 1
        for (index in 1..n) {
            for (target in 0..amount) {
                hash[index][target] += hash[index - 1][target]
                if (target >= coins[index - 1]) {
                    hash[index][target] += hash[index][target - coins[index - 1]]
                }
            }
        }
        return hash[n][amount]
    }

    // O(amount * sizeOf(coins))
    // Recursive top-down approach. Accepted.
    fun changeRecursive(amount: Int, coins: IntArray): Int {
        val hash = HashMap<Pair<Int, Int>, Int>() // Target, Index
        fun countChange(target: Int, index: Int): Int {
            if (target == 0) return 1
            if (target < 0) return 0
            if (index >= coins.size) return 0
            if (hash[target to index] != null) return hash[target to index]!!
            var count = 0
            count += countChange(target - coins[index], index)
            count += countChange(target, index + 1)
            hash[target to index] = count
            return count
        }
        return countChange(amount, 0)
    }

    // O(2^n). Works only for very small `amount`. TLE.
    fun changeSuperSlow(amount: Int, coins: IntArray): Int {
        val hash = HashSet<List<Int>>()
        fun countChange(amount: Int, currentSum: Int, coins: List<Int>, chosenCoins: MutableList<Int>): Int {
            if (currentSum == amount) {
                val sortedOptions = chosenCoins.sorted()
                return if (!hash.contains(sortedOptions)) {
                    hash.add(sortedOptions)
                    1
                } else {
                    0
                }
            }
            if (currentSum > amount) return 0
            val possibilities = coins.filter { it <= amount }
            var count = 0
            for (coin in possibilities) {
                chosenCoins.add(coin)
                if (!hash.contains(chosenCoins.sorted())) {
                    val result = countChange(amount, currentSum + coin, possibilities, chosenCoins)
                    count += result
                }
                chosenCoins.remove(coin)
            }
            return count
        }

        return countChange(amount, 0, coins.toList(), mutableListOf())
    }
}