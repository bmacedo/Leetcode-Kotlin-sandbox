package contests.biweeklyContest25

/**
 * Kids With the Greatest Number of Candies
 *
 * Given the array candies and the integer extraCandies, where candies[i] represents the number
 * of candies that the ith kid has.
 *
 * For each kid check if there is a way to distribute extraCandies among the kids such that he
 * or she can have the greatest number of candies among them. Notice that multiple kids can have
 * the greatest number of candies.
 */
fun main(args: Array<String>) {
    val candies = intArrayOf(2, 3, 5, 1, 3)
    val extraCandies = 3
    println(KidsWithGreatestNumberOfCandies.kidsWithCandies(candies, extraCandies).toList())
}

object KidsWithGreatestNumberOfCandies {

    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val max = candies.max() ?: 0
        val output = mutableListOf<Boolean>()
        candies.forEach { kid ->
            output.add(kid + extraCandies >= max)
        }

        return output.toBooleanArray()
    }

}