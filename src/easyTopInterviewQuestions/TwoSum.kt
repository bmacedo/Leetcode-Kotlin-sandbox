package easyTopInterviewQuestions

fun main(args: Array<String>) {
    val input = intArrayOf(2, 7, 15)
    val target = 9
    println(TwoSum.twoSum(input, target).toList())
}

object TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hash = HashMap<Int, Int>()
        nums.forEachIndexed { index, num ->
            if (hash.containsKey(target - num)) {
                return intArrayOf(hash[target-num]!!, index)
            } else {
                hash[num] = index
            }
        }
        throw RuntimeException("not found")
    }
}