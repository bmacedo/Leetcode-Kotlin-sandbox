package challenges.august30DaysChallenge


/**
 * Fizz Buzz
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for
 * the multiples of five output “Buzz”. For numbers which are multiples of both three
 * and five output “FizzBuzz”.
 */
fun main(args: Array<String>) {
    println(Leetcode30DayChallenge26.fizzBuzz(15))
}

object Leetcode30DayChallenge26 {

    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in 1..n) {
            val strBuilder = StringBuilder()
            if (i % 3 == 0) strBuilder.append("Fizz")
            if (i % 5 == 0) strBuilder.append("Buzz")
            val str = strBuilder.takeIf { it.isNotEmpty() }?.toString() ?: i.toString()
            result.add(str)
        }
        return result
    }
}