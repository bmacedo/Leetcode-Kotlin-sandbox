package challenges.may30DaysChallenge

import java.util.*


/**
 * Online Stock Span
 *
 * Write a class StockSpanner which collects daily price quotes for some stock,
 * and returns the span of that stock'spans price for the current day.
 *
 * The span of the stock'spans price today is defined as the maximum number of consecutive
 * days (starting from today and going backwards) for which the price of the stock was
 * less than or equal to today'spans price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
fun main(args: Array<String>) {
    val s = StockSpanner()
    assert(s.next(100) == 1)
    assert(s.next(80) == 1)
    assert(s.next(60) == 1)
    assert(s.next(70) == 2)
    assert(s.next(60) == 1)
    assert(s.next(75) == 4)
    assert(s.next(85) == 6)
}

class StockSpanner {

    /**
     * Optimal solution
     *
     * worst case will still be O(n), but will be better for most cases.
     */
    data class Span(val price: Int, val value: Int)

    var spans = Stack<Span>()

    fun next(price: Int): Int {
        var span = 1
        while (spans.isNotEmpty() && price >= spans.peek().price) {
            val previousSpan = spans.pop()
            span += previousSpan.value
        }
        spans.push(Span(price, span))
        return span
    }

    /**
     * Naive solution
     *
     * O(n) time. May scan the entire list.
     */

    private val arr = mutableListOf<Int>()

    fun nextSlow(price: Int): Int {
        arr.add(price)
        var count = 0
        var i = arr.lastIndex
        while (i in arr.indices && arr[i] <= price) {
            count++
            i--
        }
        return count
    }
}

