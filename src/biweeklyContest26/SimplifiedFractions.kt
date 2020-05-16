package biweeklyContest26

/**
 * Simplified Fractions
 *
 * Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive)
 * such that the denominator is less-than-or-equal-to n.
 *
 * The fractions can be in any order.
 */
fun main(args: Array<String>) {
    val n = 1
    println(SimplifiedFractions.simplifiedFractions(n))
}

object SimplifiedFractions {
    fun simplifiedFractions(n: Int): List<String> {
        var denominator = 1
        var numerator = 1

        val result = mutableListOf<String>()
        val divisions = mutableListOf<Float>()

        while (numerator < n) {
            denominator = 1
            while (denominator <= n) {
                val fractionFloat = numerator.toFloat()/denominator.toFloat()
                if (fractionFloat < 1 && !divisions.contains(fractionFloat)) {
                    result.add("$numerator/$denominator")
                    divisions.add(fractionFloat)
                }
                denominator++
            }
            numerator++
        }
        return result
    }
}