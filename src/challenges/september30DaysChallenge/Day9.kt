package challenges.september30DaysChallenge


/**
 * Compare Version Numbers
 *
 * Compare two version numbers version1 and version2.
 *
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0.
 * For example, version number 3.4 has a revision number of 3 and 4 for its first and second level
 * revision number. Its third and fourth level revision number are both 0.
 */
fun main(args: Array<String>) {
    val version1 = "1.01"
    val version2 = "1.001"
    println(Day9.compareVersion(version1, version2))
}

object Day9 {

    fun compareVersion(version1: String, version2: String): Int {
        val v1Digits = version1.split(".").map { it.toInt() }
        val v2Digits = version2.split(".").map { it.toInt() }

        val lastIndex = maxOf(v1Digits.lastIndex, v2Digits.lastIndex)

        for (i in 0..lastIndex) {
            val digitV1 = v1Digits.getOrNull(i) ?: 0
            val digitV2 = v2Digits.getOrNull(i) ?: 0

            if (digitV1 > digitV2) return 1
            else if (digitV1 < digitV2) return -1
        }
        return 0
    }
}


