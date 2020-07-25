package practice.adhoc

/**
 * Given the array queries of positive integers between 1 and m,
 * you have to process all queries[i] (from i=0 to i=queries.length-1)
 * according to the following rules:
 *
 *  - In the beginning, you have the permutation P=[1,2,3,...,m].
 *
 *  - For the current i, find the position of queries[i] in the
 *  permutation P (indexing from 0) and then move this at the beginning
 *  of the permutation P. Notice that the position of queries[i] in P
 *  is the result for queries[i].
 *
 * Return an array containing the result for the given queries.
 */
fun main(args: Array<String>) {
    val input = intArrayOf(4,1,2,2)
    val m = 4
    println(QueriesPermutationWithKey.processQueries(input, m).toList())
}

object QueriesPermutationWithKey {

    fun processQueries(queries: IntArray, m: Int): IntArray {
        val p = (1..m).toMutableList()
        val result = mutableListOf<Int>()
        for (i in queries.indices) {
            val queryResult = queries[i]
            val resultPosition = p.indexOf(queryResult)
            result.add(resultPosition)
            p.removeAt(resultPosition)
            p.add(0, queryResult)
        }
        return result.toIntArray()
    }
}