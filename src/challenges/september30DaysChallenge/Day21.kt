package challenges.september30DaysChallenge

/**
 * Car Pooling
 *
 * You are driving a vehicle that has capacity empty seats initially available for passengers.
 * The vehicle only drives east (ie. it cannot turn around and drive west.)
 *
 * Given a list of trips, trip[ i ] = [num_passengers, start_location, end_location] contains
 * information about the i-th trip: the number of passengers that must be picked up, and the
 * locations to pick them up and drop them off.
 *
 * The locations are given as the number of kilometers due east from your vehicle's initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 */
fun main(args: Array<String>) {
    println(Day21.carPooling(
            arrayOf(
                    intArrayOf(3, 2, 7),
                    intArrayOf(3, 7, 9),
                    intArrayOf(8, 3, 9)
            ), 11
    ))
}

object Day21 {

    // O(n)?
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val map = IntArray(1001)
        for (trip in trips) {
            val (quantity, start, end) = trip
            for (i in start until end) {
                map[i] += quantity
                if (map[i] > capacity) return false
            }
        }
        return true
    }
}