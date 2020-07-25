package contests.kotlinheroes4

fun main(args: Array<String>) {
    val times = readLine()!!.toInt()
    repeat(times) {
        val (_, k1, k2) = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }
        val str = readLine()!!
        println(Bootcamp.maxLectures(str, k1, k2))
    }
}

object Bootcamp {
    fun maxLectures(schedule: String, maxPerDay: Int, maxConsecutiveDays: Int): Int {
        val lectures = mutableListOf<Int>()
        schedule.forEach {
            if (it == '0') {
                lectures.add(0)
            } else {
                val previousSum = lectures.lastOrNull() ?: 0
                val allowedLectures = Math.min(maxPerDay, maxConsecutiveDays - previousSum)
                lectures.add(allowedLectures)
            }
        }
        return lectures.sum()
    }
}