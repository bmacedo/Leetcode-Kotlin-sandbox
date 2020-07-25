package challenges.april30DaysChallenge
fun main(args: Array<String>) {
    val input = 19
    println(Leetcode30DayChallenge2.isHappy(input))
}

object Leetcode30DayChallenge2 {

    fun isHappy(n: Int): Boolean {
        var digits = destruct(n)
        repeat(10000) {
            val sum = digits.map { it * it }.sum()

            if (sum == 1) {
                return true
            }

            digits = destruct(sum)
        }
        return false
    }

    private fun destruct(n: Int) = n.toString().split("").mapNotNull { it.toIntOrNull() }
}
