package practice.easyTopInterviewQuestions

/**
 * String to Integer (atoi)
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found.
 *
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as
 * many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace
 * characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 * -    Only the space character ' ' is considered as whitespace character.
 * -    Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1].
 *
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1)
 * or INT_MIN (−231) is returned.
 */
fun main(args: Array<String>) {
    val input = "20000000000000000000"
    println(StringToInt.myAtoi(input))
}

object StringToInt {
    fun myAtoi(str: String): Int {
        if (str.isEmpty()) return 0

        var startIndex = 0
        var isPositive = true
        while (startIndex < str.length) {
            if (str[startIndex] !in ('0'..'9')) {
                if (str[startIndex] != ' ') {
                    if (str[startIndex] in listOf('-', '+')) {
                        val nextIndex = startIndex + 1
                        if (nextIndex !in str.indices || str[nextIndex] !in ('0'..'9')) return 0

                        isPositive = str[startIndex] == '+'
                    } else {
                        return 0
                    }
                }
                startIndex++
            } else {
                break
            }
        }

        if (startIndex !in str.indices) return 0

        var endIndex = startIndex + 1
        while (endIndex in str.indices && str[endIndex] in ('0'..'9')) {
            endIndex++
        }
        endIndex--

        var result = 0L
        var count = endIndex - startIndex
        for (i in startIndex..endIndex) {
            val digit = (str[i] - '0') * (Math.pow(10.0, count.toDouble())).toLong()
            result += digit
            if (result < 0) {
                return if (isPositive) Int.MAX_VALUE else Int.MIN_VALUE
            }
            count--
        }
        return if ((result > Int.MAX_VALUE || result < Int.MIN_VALUE) && isPositive) {
            Int.MAX_VALUE
        } else if ((result > Int.MAX_VALUE || result < Int.MIN_VALUE) && !isPositive) {
            Int.MIN_VALUE
        } else if (!isPositive) {
            -result.toInt()
        } else {
            result.toInt()
        }
    }
}