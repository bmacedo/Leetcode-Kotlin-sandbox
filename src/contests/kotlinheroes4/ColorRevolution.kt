package contests.kotlinheroes4

fun main(args: Array<String>) {
    val times = readLine()!!.toInt()
    repeat(times) {
        val (n, k) = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }
        ColorRevolution.factor(n, k)
    }
}

object ColorRevolution {
    fun factor(n: Int, k: Int) {
        val k2 = k * k
        val k3 = k2 * k
        val factors = 1 + k + k2 + k3
        val n1 = n / factors
        println("$n1 ${n1 * k} ${n1 * k2} ${n1 * k3}")
    }
}