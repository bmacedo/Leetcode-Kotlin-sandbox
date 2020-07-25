package challenges.june30DaysChallenge

import java.util.*
import kotlin.collections.HashMap


/**
 * Reconstruct Itinerary
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order.
 *
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 * - If there are multiple valid itineraries, you should return the itinerary that has the smallest
 * lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller
 * lexical order than ["JFK", "LGB"].
 *
 * - All airports are represented by three capital letters (IATA code).
 *
 * - You may assume all tickets form at least one valid itinerary.
 *
 * - One must use all the tickets once and only once.
 */
fun main(args: Array<String>) {
//    val input = listOf(
//            listOf("JFK", "SFO"),
//            listOf("JFK", "ATL"),
//            listOf("SFO", "ATL"),
//            listOf("ATL", "JFK"),
//            listOf("ATL", "SFO")
//    )
    val input = listOf(
            listOf("JFK", "KUL"),
            listOf("JFK", "NRT"),
            listOf("NRT", "JFK")
    )
    // "JFK","ATL","JFK","SFO","ATL","SFO"
    println(Leetcode30DayChallenge28.findItinerary(input))
}

object Leetcode30DayChallenge28 {

    fun findItinerary(tickets: List<List<String>>): List<String> {
        val hash = HashMap<String, PriorityQueue<String>>()

        tickets.forEach { (from, to) ->
            hash[from] = hash.getOrDefault(from, PriorityQueue()).apply { add(to) }
        }

        val path = LinkedList<String>()
        val stack = Stack<String>()
        stack.push("JFK")
        while (!stack.empty()) {
            while (hash.containsKey(stack.peek()) && hash[stack.peek()]?.isNotEmpty() == true) {
                stack.push(hash[stack.peek()]?.poll())
            }
            path.addFirst(stack.pop())
        }

        return path
    }
}
