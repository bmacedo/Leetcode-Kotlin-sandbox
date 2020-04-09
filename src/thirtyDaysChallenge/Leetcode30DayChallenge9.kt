package thirtyDaysChallenge

/**
 * Given two strings S and T, return if they are equal when both
 * are typed into empty text editors.
 *
 * # means a backspace character.
 */
fun main(args: Array<String>) {
//    val S = "bxj##tw"     // expect true
//    val T = "bxo#j##tw"
//    val S = "xywrrm"      // expect true
//    val T = "xywrrmu#"
//    val S = "bxj##tw"     // expect false
//    val T = "bxj###tw"
//    val S = "ab##"        // expect true
//    val T = "c#d#"
//    val S = "y#fo##f"     // expect true
//    val T = "y#fx#o##f"
//    val S = "a#c"         // expect false
//    val T = "b"
//    val S = "a##c"        // expect true
//    val T = "#a#c"
    val S = "ab#c"        // expect true
    val T = "ad#c"
    println(Leetcode30DayChallenge9.backspaceCompare(S, T))
}

object Leetcode30DayChallenge9 {

    // O(N) time, O(1) space
    fun backspaceCompare(S: String, T: String): Boolean {
        val string1 = S.trimStart('#')
        val string2 = T.trimStart('#')
        var sIndex = string1.lastIndex
        var tIndex = string2.lastIndex
        var skipS = 0
        var skipT = 0
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0 && string1[sIndex] == '#') {
                skipS++
                sIndex--
            }
            while (tIndex >= 0 && string2[tIndex] == '#') {
                skipT++
                tIndex--
            }
            if (skipS > 0) {
                sIndex--
                skipS--
            } else if (skipT > 0) {
                tIndex--
                skipT--
            } else if (skipS == 0 && skipT == 0) {
                if (sIndex < 0 || tIndex < 0 || string1[sIndex] != string2[tIndex]) {
                    return false
                }
                sIndex--
                tIndex--
            }
        }
        return true
    }
}
