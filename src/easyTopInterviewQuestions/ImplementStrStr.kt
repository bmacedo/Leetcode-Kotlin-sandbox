package easyTopInterviewQuestions

fun main(args: Array<String>) {
    val haystack = "hello"
    val needle = "o"
    println(ImplementStrStr.strStr(haystack, needle))
}

object ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        val count = needle.length

        var i = 0
        while (i + count <= haystack.length) {
            if (haystack[i] == needle[0]) {
                val subStr = haystack.subSequence(i, i + count)
                if (subStr == needle) return i
            }

            i++
        }

        return -1
    }
}