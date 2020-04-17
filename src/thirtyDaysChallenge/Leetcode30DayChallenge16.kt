package thirtyDaysChallenge

import java.util.*


/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid.
 *
 * We define the validity of a string by these rules:
 * -    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * -    Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * -    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * -    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '('
 *      or an empty string.
 * -    An empty string is also valid.
 */
fun main(args: Array<String>) {
    val input = "(*))("
    println(Leetcode30DayChallenge16.checkValidString(input))
}

object Leetcode30DayChallenge16 {

    fun checkValidString(s: String): Boolean {
        var levelCount = 0
        s.forEach { char ->
            when (char) {
                '(', '*' -> levelCount++
                else -> levelCount--
            }

            if (levelCount < 0) return false
        }

        levelCount = 0
        s.reversed().forEach { char ->
            when (char) {
                ')', '*' -> levelCount++
                else -> levelCount--
            }

            if (levelCount < 0) return false
        }
        return true
    }

//    fun checkValidString(s: String): Boolean {
//        val sums = mutableListOf<Int>()
//        populateSum(s, sums)
//        return sums.contains(0)
//    }
//
//    private fun populateSum(s: String, sums: MutableList<Int>) {
//
//        val asteriskIndex = s.indexOf('*')
//
//        if (asteriskIndex >= 0) {
//            val s1 = s.replaceFirst('*', '(')
//            populateSum(s1, sums)
//            val s2 = s.replaceFirst('*', ')')
//            populateSum(s2, sums)
//            val s3 = StringBuilder(s).deleteCharAt(asteriskIndex).toString()
//            populateSum(s3, sums)
//        } else {
//            var sum = 0
//            s.forEach { char ->
//                when (char) {
//                    '(' -> sum += 1
//                    ')' -> sum -= 1
//                }
//                if (sum < 0) return
//            }
//            sums.add(sum)
//        }
//
//
//
//
//        when (s[0]) {
//            '(' -> for (i in sums.indices) sums[i] += 1
//            ')' -> for (i in sums.indices) sums[i] -= 1
//            '*' -> {
//                val lastSum = sums.last()
//                sums.add(lastSum)
//                populateSum('(' + s.substring(1), sums)
//                sums.add(lastSum)
//                populateSum(')' + s.substring(1), sums)
//            }
//        }
//        populateSum(s.substring(1), sums)
//    }

//    fun checkValidString(s: String): Boolean {
//        val regex = "c*((a|c)c*(b|c))*c*".toRegex()
//        return s.map {
//            when (it) {
//                '(' -> 'a'
//                ')' -> 'b'
//                '*' -> 'c'
//                else -> throw IllegalArgumentException()
//            }
//        }.joinToString("").matches(regex)
//    }

//    fun checkValidString(s: String): Boolean {
//        if (s.isEmpty()) return true
//        val hashMap = HashMap<Char, MutableList<Int>>()
//        s.forEachIndexed { index, char ->
//            if (hashMap.containsKey(char)) {
//                hashMap[char]?.add(index)
//            } else {
//                hashMap[char] = mutableListOf(index)
//            }
//        }
//        while (hashMap.values.flatten().isNotEmpty()) {
//            val index1 = hashMap['(']?.firstOrNull()
//            val index2 = hashMap[')']?.firstOrNull()
//            val index3 = hashMap['*']?.firstOrNull()
//
//            if (index2 == null && index1 != null && index3 != null && index3 > index1) {
//                hashMap['(']?.removeAt(0)
//                hashMap['*']?.removeAt(0)
//            } else if (index1 == null && index2 != null && index3 != null && index3 < index2) {
//                hashMap['*']?.removeAt(0)
//                hashMap[')']?.removeAt(0)
//            } else if (index1 != null && index2 != null && index1 < index2) {
//                hashMap['(']?.removeAt(0)
//                hashMap[')']?.removeAt(0)
//            } else {
//                return false
//            }
//        }
//        return true
//    }

}
