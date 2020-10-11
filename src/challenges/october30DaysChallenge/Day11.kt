package challenges.october30DaysChallenge

import java.util.*
import kotlin.collections.HashMap


/**
 * Remove Duplicate Letters
 *
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 */
fun main(args: Array<String>) {
//    println(Day11.removeDuplicateLetters("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"))
    println(Day11.removeDuplicateLetters("leetcode"))
}

object Day11 {

    fun removeDuplicateLetters(s: String): String {
        val lastIndex = HashMap<Char, Int>() // Char, Index
        for (i in s.indices) lastIndex[s[i]] = i // track the lastIndex of character presence

        val seen = HashMap<Char, Boolean>() // keep track seen

        val st: Stack<Char> = Stack()
        for (i in s.indices) {
            val c: Char = s[i]
            if (seen[c] == true) continue  // if seen continue as we need to pick one char only
            while (!st.isEmpty() && st.peek()!! > c && i < lastIndex[st.peek()!!]!!) {
                seen[st.pop()!!] = false // pop out and mark unseen
            }
            st.push(c) // add into stack
            seen[c] = true // mark seen
        }

        val sb = StringBuilder()
        while (!st.isEmpty()) sb.append((st.pop()))
        return sb.reverse().toString()
    }
}