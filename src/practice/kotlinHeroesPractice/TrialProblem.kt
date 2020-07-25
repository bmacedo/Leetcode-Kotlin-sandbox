package practice.kotlinHeroesPractice

/**
 * You are given two integers 𝑎 and 𝑏. Print 𝑎+𝑏.
 *
 * Input
 * The first line contains an integer 𝑡 (1≤𝑡≤104) — the number of test cases in the input.
 *
 * Output
 * Print 𝑡 integers — the required numbers 𝑎+𝑏.
 */
fun main(args: Array<String>) {
    val n = readLine()!!.toInt() // read integer from the input
    repeat(n) {
        val (a, b) = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }
        println(a + b)
    }
}