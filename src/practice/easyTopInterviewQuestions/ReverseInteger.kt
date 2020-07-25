package practice.easyTopInterviewQuestions

/**
 * Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note: return 0 when the reversed integer overflows.
 */
fun main(args: Array<String>) {
    val input = 120
    println(ReverseInteger.reverse(input))
}

object ReverseInteger {
    fun reverse(x: Int): Int {
        val isNegative = x < 0
        val xStr = x.toString().filter { it.isDigit() }.toCharArray()
        val result = StringBuilder()
        if (isNegative) {
            result.append("-")
        }
        val lastIndex = xStr.lastIndex
        for (i in 0 until xStr.size / 2) {
            val temp = xStr[i]
            xStr[i] = xStr[lastIndex - i]
            xStr[lastIndex - i] = temp
        }
        xStr.forEach { result.append(it) }

        return result.toString().toIntOrNull() ?: 0
    }
}