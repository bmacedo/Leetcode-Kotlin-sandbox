package may30DaysChallenge

/**
 * Find the Town Judge
 *
 * In a town, there are N people labelled from 1 to N.
 * There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 * -    The town judge trusts nobody.
 * -    Everybody (except for the town judge) trusts the town judge.
 * -    There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given trust, an array of pairs trust[ i ] = [a, b] representing that the person
 * labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.
 * Otherwise, return -1.
 */
fun main(args: Array<String>) {
    val input = arrayOf<IntArray>(
            intArrayOf(1,3),
            intArrayOf(2,3),
            intArrayOf(3,1)
    )
    val n = 3
    println(Leetcode30DayChallenge10.findJudge(n, input))
}

object Leetcode30DayChallenge10 {

    // O(n) time, O(n) space, 2 pass, simple logic
    fun findJudge(N: Int, arr: Array<IntArray>): Int {
        val trust = IntArray(N) { 0 }
        val trusted = IntArray(N) { 0 }

        for (i in arr.indices) {
            val (a,b) = arr[i]
            trust[a-1]++
            trusted[b-1]++
        }
        for (i in 0 until N) {
            if (trust[i] == 0 && trusted[i] == N-1) return i+1
        }
        return -1
    }

    // O(n) time, O(n) space, multiple pass
    fun findJudgeSlow(N: Int, trust: Array<IntArray>): Int {
        if (trust.isEmpty() && N == 1) return 1

        val trustMap = HashMap<Int, MutableSet<Int>>()
        trust.forEach { (trustee,trusted) ->
            val peopleWhoTrustB = trustMap.getOrDefault(trusted, HashSet()).apply { add(trustee) }
            trustMap[trusted] = peopleWhoTrustB
        }

        // Consider only a citizen trusted by n-1 other citizens. Any other cannot be a judge.
        val possibleJudges = trustMap.filter { it.value.size >= N-1 }

        // There should be one, and only one, judge
        if (possibleJudges.size != 1) return -1

        val possibleJudge = possibleJudges.entries.first()

        trust.forEach { (trustee,_) ->
            // The judge should trust no one.
            if (trustee == possibleJudge.key) return -1
        }
        return possibleJudge.key
    }
}


