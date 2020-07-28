package challenges.july30DaysChallenge

import java.util.*
import kotlin.collections.HashMap


/**
 * Task Scheduler
 *
 * You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where
 * each letter represents a different task. Tasks could be done without the original order of the array.
 * Each task is done in one unit of time.
 *
 * For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks
 * (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 *
 * You need to return the least number of units of times that the CPU will take to finish all the given tasks.
 */
fun main(args: Array<String>) {
    val input = charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G')
    println(Leetcode30DayChallenge28.leastInterval(input, 2))
}


object Leetcode30DayChallenge28 {


    data class Task(val priority: Int, val name: Char, val count: Int)

    // Accepted. But kind of slow since all the elements need to be removed and added again to the queue
    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0) tasks.size

        val priorityQueue = PriorityQueue<Task> { t1, t2 ->
            var result = t1.priority.compareTo(t2.priority)
            if (result == 0) result = -t1.count.compareTo(t2.count)
            result
        }

        fillPriorityQueue(tasks, priorityQueue)

        var result = 0
        while (priorityQueue.isNotEmpty()) {
            val selectedTask = priorityQueue.poll()

            result += 1

            decreasePriorityOnAllTasks(priorityQueue)
            if (selectedTask.priority > 0) {
                priorityQueue.add(selectedTask.copy(priority = selectedTask.priority - 1))
            } else {
                if (selectedTask.count > 1) {
                    priorityQueue.add(selectedTask.copy(priority = n, count = selectedTask.count - 1))
                }
            }
        }
        return result
    }

    private fun decreasePriorityOnAllTasks(priorityQueue: PriorityQueue<Task>) {
        val temp = mutableListOf<Task>()
        while (priorityQueue.isNotEmpty()) {
            var task = priorityQueue.poll()
            if (task.priority > 0) task = task.copy(priority = task.priority - 1)
            temp.add(task)
        }

        while (temp.isNotEmpty()) {
            priorityQueue.add(temp.first())
            temp.removeAt(0)
        }
    }

    private fun fillPriorityQueue(tasks: CharArray, priorityQueue: PriorityQueue<Task>) {
        val hash = HashMap<Char, Int>() // Name, Count
        tasks.forEach { name -> hash[name] = hash.getOrDefault(name, 0) + 1 }
        hash.forEach { name, count -> priorityQueue.add(Task(0, name, count)) }
    }
}
