package challenges.april30DaysChallenge

import java.util.*

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */
fun main(args: Array<String>) {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    assert(minStack.getMin() == -3)
    minStack.pop()
    assert(minStack.top() == 0)
    assert(minStack.getMin() == -2)
}

class MinStack {

    data class Node(val value: Int, val min: Int)

    private val stack = ArrayDeque<Node>()

    fun push(x: Int) {
        if (stack.isEmpty()) {
            stack.push(Node(x, x))
        } else {
            val newMin = Math.min(x, getMin())
            stack.push(Node(x, newMin))
        }
    }

    fun pop() = stack.pop()

    fun top(): Int = stack.first.value

    fun getMin(): Int = stack.first.min

}
