package challenges.august30DaysChallenge

import challenges.august30DaysChallenge.Leetcode30DayChallenge5.WordDictionary
import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue


/**
 * Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:
 * - void addWord(word)
 * - bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 *
 * A . means it can represent any one letter.
 */
fun main(args: Array<String>) {
    with(WordDictionary()) {
        addWord("bad")
        addWord("dad")
        addWord("mad")
        assertFalse(search("pad"))
        assertTrue(search("bad"))
        assertTrue(search(".ad"))
        assertTrue(search("b.."))
    }
}

object Leetcode30DayChallenge5 {

    class WordDictionary {

        internal class TrieNode {
            var children: MutableMap<Char, TrieNode> = HashMap()
            var endOfWord: Boolean = false
        }

        private var root = TrieNode()

        /** Adds a word into the data structure.  */
        fun addWord(word: String) {
            var current = root
            for (i in 0 until word.length) {
                val c = word[i]
                var node: TrieNode? = current.children[c]
                if (node == null) {
                    node = TrieNode()
                    current.children[c] = node
                }

                current = node
            }

            current.endOfWord = true
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.'
         * to represent any one letter.  */
        fun search(word: String): Boolean {
            return searchRecursive(root, word, 0)
        }

        private fun searchRecursive(current: TrieNode, word: String, index: Int): Boolean {
            if (index == word.length)
                return current.endOfWord

            val c = word[index]
            when {
                current.children.containsKey(c) -> return searchRecursive(current.children[c]!!, word, index + 1)
                c == '.' -> {
                    var result = false
                    for ((_, value) in current.children) {
                        if (index == word.length - 1)
                            return value.endOfWord

                        if (searchRecursive(value, word, index + 1))
                            result = true
                    }
                    return result
                }
                else -> return false
            }
        }
    }
}