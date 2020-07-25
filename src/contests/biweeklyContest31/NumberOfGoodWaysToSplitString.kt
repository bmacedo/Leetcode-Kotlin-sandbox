package contests.biweeklyContest31

/**
 * Number of Good Ways to Split a String
 *
 * You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q
 * where its concatenation is equal to s and the number of distinct letters in p and q are the same.
 *
 * Return the number of good splits you can make in s.
 */
fun main(args: Array<String>) {
    val s = "aaaaa"
    println(NumberOfGoodWaysToSplitString.numSplits(s))
}

object NumberOfGoodWaysToSplitString {

    // Time limit exceeded
    fun numSplits(s: String): Int {
        fun isGoodSplit(p: String, q: String): Boolean {
            val distinctLettersInP = p.toCharArray().distinct().count()
            val distinctLettersInQ = q.toCharArray().distinct().count()
            return distinctLettersInP == distinctLettersInQ
        }

        var count = 0
        for (i in 1 until s.length) {
            val p = s.subSequence(0, i)
            val q = s.subSequence(i, s.length)
            if (isGoodSplit(p.toString(), q.toString())) count++
        }
        return count
    }
}