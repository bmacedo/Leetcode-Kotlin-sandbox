package july30DaysChallenge


/**
 * Angle Between Hands of a Clock
 *
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 */
fun main(args: Array<String>) {
    val hour = 12
    val min = 0
    println(Leetcode30DayChallenge14.angleClock(hour, min))
}


object Leetcode30DayChallenge14 {

    fun angleClock(hour: Int, minutes: Int): Double {

        fun normalize(minutes: Int): Double = minutes / 60.0

        val localHour = hour % 12
        val angleMin = minutes * 6
        val angleHour = (localHour + normalize(minutes)) * 30
        val angle = Math.abs(angleHour - angleMin)
        return minOf(360 - angle, angle)
    }
}
