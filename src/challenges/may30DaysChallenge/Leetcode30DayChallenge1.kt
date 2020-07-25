package challenges.may30DaysChallenge

/**
 * First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version.
 *
 * You should minimize the number of calls to the API.
 */
fun main(args: Array<String>) {
    val input = 2126753390
    println(Leetcode30DayChallenge1.firstBadVersion(input))
}

object Leetcode30DayChallenge1 : VersionControl() {

    fun firstBadVersion(n: Int): Int {
        var start = 1
        var end = n
        while (start < end) {
            val midpoint = ((start.toLong() + end.toLong()) / 2L).toInt()
            if (isBadVersion(midpoint)) {
                end = midpoint
            } else {
                start = midpoint + 1
            }
        }
        return start
    }
}

open class VersionControl {

    fun isBadVersion(n: Int) = n >= 1702766719

}


