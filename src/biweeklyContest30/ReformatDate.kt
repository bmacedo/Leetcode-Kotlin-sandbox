package biweeklyContest30

/**
 * Reformat Date
 *
 * Given a date string in the form Day Month Year, where:
 * - Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * - Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
 * - Year is in the range [1900, 2100].
 *
 * Convert the date string to the format YYYY-MM-DD, where:
 * - YYYY denotes the 4 digit year.
 * - MM denotes the 2 digit month.
 * - DD denotes the 2 digit day.
 */
fun main(args: Array<String>) {
    val input = "6th Jun 1933"
    println(ReformatDate.reformatDate(input))
}

object ReformatDate {
    fun reformatDate(date: String): String {
        val months = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

        val year = date.takeLast(4)
        val month = date.dropLast(4).trim().takeLast(3)
        val day = date.dropLast(7).trim().takeWhile { it.isDigit() }.padStart(2, '0')

        val monthIndex = (months.indexOf(month) + 1).toString().padStart(2, '0')

        return "$year-$monthIndex-$day"
    }
}