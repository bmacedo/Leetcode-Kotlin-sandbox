package challenges.september30DaysChallenge


fun main(args: Array<String>) {
    val input = intArrayOf(3, 10, 5, 25, 2, 8)
    println(Day16.findMaximumXOR(input))
}

object Day16 {
    fun findMaximumXOR(nums: IntArray): Int {
        val maxNum: Int = nums.max() ?: 0
        val maxBitsPossible = Integer.toBinaryString(maxNum).length

        var maxXor = 0
        var currXor: Int
        val prefixes = mutableSetOf<Int>()

        for (i in maxBitsPossible - 1 downTo 0) {
            prefixes.clear()
            for (num in nums) prefixes.add(num shr i)

            maxXor = maxXor shl 1
            currXor = maxXor or 1

            for (p in prefixes) {
                if (prefixes.contains(currXor xor p)) {
                    maxXor = currXor
                    break
                }
            }
        }

        return maxXor
    }
}