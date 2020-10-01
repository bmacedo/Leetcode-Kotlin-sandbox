package challenges.october30DaysChallenge

import challenges.october30DaysChallenge.Day1.RecentCounter
import kotlin.test.assertEquals


/**
 * Number of Recent Calls
 *
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 *
 * Implement the RecentCounter class:
 *
 * - RecentCounter() Initializes the counter with zero recent requests.
 *
 * - int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns
 * the number of requests that has happened in the past 3000 milliseconds (including the new request).
 * Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 *
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 */
fun main(args: Array<String>) {
    val recentCounter = RecentCounter()
    assertEquals(1, recentCounter.ping(1))     // requests = [1], range is [-2999,1], return 1
    assertEquals(2, recentCounter.ping(100))   // requests = [1, 100], range is [-2900,100], return 2
    assertEquals(3, recentCounter.ping(3001))  // requests = [1, 100, 3001], range is [1,3001], return 3
    assertEquals(3, recentCounter.ping(3002))  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
}

object Day1 {
    class RecentCounter {

        private val list = ArrayList<Int>()

        fun ping(t: Int): Int {
            val lowerBound = t - 3000
            val iterator = list.iterator()
            while (iterator.hasNext()) {
                if (iterator.next() < lowerBound) {
                    iterator.remove()
                } else {
                    break
                }
            }
            list.add(t)
            return list.size
        }

    }
}