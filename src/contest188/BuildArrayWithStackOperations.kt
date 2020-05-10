package contest188

/**
 * Build an Array With Stack Operations
 *
 * Given an array target and an integer n.
 * In each iteration, you will read a number from  list = {1,2,3..., n}
 *
 * Build the target array using the following operations:
 * - Push: Read a new element from the beginning list, and push it in the array.
 * - Pop: delete the last element of the array.
 * - If the target array is already built, stop reading more elements.
 *
 * You are guaranteed that the target array is strictly increasing,
 * only containing numbers between 1 to n inclusive.
 *
 * Return the operations to build the target array.
 * You are guaranteed that the answer is unique.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(2,3,4)
    val target = 4
    println(BuildArrayWithStackOperations.buildArray(input, target))
}

object BuildArrayWithStackOperations {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val output = mutableListOf<String>()
        val mirror = mutableListOf<Int>()
        val list = (1..n)
        list.forEach { num ->
            if (mirror == target.toList()) return output
            val targetLast = target[mirror.size]
            if (targetLast == num) {
                mirror.add(num)
                output.add("Push")
            } else {
                output.add("Push")
                output.add("Pop")
            }
        }
        return output
    }
}