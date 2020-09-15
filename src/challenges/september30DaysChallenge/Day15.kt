package challenges.september30DaysChallenge

fun main(args: Array<String>) {
    println(Day15.lengthOfLastWord("hello world"))
}

object Day15 {
    fun lengthOfLastWord(s: String): Int {
        return s.split(" ")
                .lastOrNull { it.isNotEmpty() }
                ?.length ?: 0
    }
}