package practice.kotlinHeroesPractice

/**
 * Square?
 *
 * Vasya claims that he had a paper square. He cut it into two rectangular parts using one vertical
 * or horizontal cut. Then Vasya informed you the dimensions of these two rectangular parts.
 *
 * You need to check whether Vasya originally had a square.
 *
 * In other words, check if it is possible to make a square using two given rectangles.
 *
 * Input
 * The first line contains an integer 𝑡 (1≤𝑡≤104) — the number of test cases in the input.
 * Each test case is given in two lines.
 *
 * The first line contains two integers 𝑎1 and 𝑏1 (1≤𝑎1,𝑏1≤100) — the dimensions of the first one obtained after cutting rectangle.
 * The sizes are given in random order (that is, it is not known which of the numbers is the width, and which of the numbers is the length).
 *
 * The second line contains two integers 𝑎2 and 𝑏2 (1≤𝑎2,𝑏2≤100) — the dimensions of the second obtained after cutting rectangle.
 * The sizes are given in random order (that is, it is not known which of the numbers is the width, and which of the numbers is the length).
 *
 * Output
 * Print 𝑡 answers, each of which is a string "YES" (in the case of a positive answer)
 * or "NO" (in the case of a negative answer).
 *
 * The letters in words can be printed in any case (upper or lower).
 */
fun main(args: Array<String>) {
    val n = readLine()!!.toInt() // read integer from the input
    repeat(n) {
        val (x1, y1) = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }
        val (x2, y2) = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }

        var ans = "No"
        val h = Math.max(x1, y1)
        if (Math.max(x2, y2) == h) {
            val w1 = Math.min(x1, y1)
            val w2 = Math.min(x2, y2)
            if (w1 + w2 == h) ans = "Yes"
        }
        println(ans)
    }
}