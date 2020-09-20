package challenges.september30DaysChallenge

import java.util.*

/**
 * Sequential Digits
 *
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 */
fun main(args: Array<String>) {
    println(Day19.sequentialDigits(477791556, 700136456))
}

object Day19 {

    // O(n logn)
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val minSet = TreeSet<Int?>().apply {
            add(0)
            add(1)
            add(12)
            add(123)
            add(1234)
            add(12345)
            add(123456)
            add(1234567)
            add(12345678)
            add(123456789)
        }

        val maxSet = TreeSet<Int?>().apply {
            add(9)
            add(89)
            add(789)
            add(6789)
            add(56789)
            add(456789)
            add(3456789)
            add(23456789)
            add(123456789)
        }

        val sumList = TreeSet<Int>().apply {
            add(1)
            add(11)
            add(111)
            add(1111)
            add(11111)
            add(111111)
            add(1111111)
            add(11111111)
            add(111111111)
        }

        if (low > maxSet.last()!!) return emptyList()

        // O(n)?
        var first = low
        while (!isSequential(first) && first < high) first++
        if (!isSequential(first)) return emptyList()

        val result = mutableListOf<Int>()

        var current = first
        // O(n logn)
        while (current <= high) {
            result.add(current)
            val floorMax = maxSet.floor(current) // O(logn)
            if (current == floorMax) {
                current = minSet.ceiling(current + 1) ?: break // O(logn)
            } else {
                current += sumList.floor(current) // O(logn)
            }
        }

        return result
    }

    // O(1)?
    private fun isSequential(number: Int): Boolean {
        var current = number
        var previousDigit: Int? = null
        while (current > 0) {
            val lastDigit = current % 10
            if (previousDigit != null && lastDigit != previousDigit - 1) return false
            current /= 10
            previousDigit = lastDigit
        }
        return true
    }
}