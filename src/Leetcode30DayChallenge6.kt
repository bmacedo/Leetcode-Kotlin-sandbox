fun main(args: Array<String>) {
//    val input = emptyArray<String>()
//    val input = arrayOf("cab","tin","pew","duh","may","ill","buy","bar","max","doc")
    val input = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(Leetcode30DayChallenge6.groupAnagrams(input))
}

object Leetcode30DayChallenge6 {

    fun groupAnagrams(strs: Array<String>): List<List<String>> = strs
            .groupBy { it.toCharArray().sorted().toString() }
            .map { it.value }
}
