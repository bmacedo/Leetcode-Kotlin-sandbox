package challenges.june30DaysChallenge


/**
 * Word Search II
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring.
 *
 * The same letter cell may not be used more than once in a word.
 */
fun main(args: Array<String>) {
    val board = arrayOf(
            charArrayOf('o', 'a', 'a', 'n'),
            charArrayOf('e', 't', 'a', 'e'),
            charArrayOf('i', 'h', 'k', 'r'),
            charArrayOf('i', 'f', 'l', 'v')
    )
    val words = arrayOf("oath", "pea", "eat", "rain")
    println(Leetcode30DayChallenge30.findWords(board, words))
}

object Leetcode30DayChallenge30 {

    /**
     * Optimized solution using Trie
     */

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val res = ArrayList<String>()

        // Create the prefix tree
        val root = createTrie(words)

        for (i in board.indices) {
            for (j in board[0].indices) {
                DFS(board, i, j, root, res)
            }
        }
        return res
    }

    private fun DFS(board: Array<CharArray>, row: Int, col: Int, root: TrieeNode, result: ArrayList<String>) {
        var p: TrieeNode? = root
        val c = board[row][col]

        if (c == '#' || p!!.next[c - 'a'] == null) {
            return
        }

        p = p.next[c - 'a']

        if (p!!.word != null) {
            result.add(p.word!!)
            p.word = null
        }

        board[row][col] = '#'
        if (row > 0) DFS(board, row - 1, col, p, result)
        if (col > 0) DFS(board, row, col - 1, p, result)
        if (row < board.size - 1) DFS(board, row + 1, col, p, result)
        if (col < board[0].size - 1) DFS(board, row, col + 1, p, result)
        board[row][col] = c
    }


    private fun createTrie(words: Array<String>): TrieeNode {
        val root = TrieeNode()

        for (w in words) {

            var p: TrieeNode? = root
            for (c in w.toCharArray()) {
                val i = c - 'a'
                if (p!!.next[i] == null) {
                    p.next[i] = TrieeNode()
                }
                p = p.next[i]
            }

            p?.word = w
        }
        return root
    }

    // Node for the prefix tree (Trie)
    class TrieeNode {
        var next = arrayOfNulls<TrieeNode>(26)
        var word: String? = null
    }


    /**
     * Slow solution below.
     */


    // O(n * m); n = number of cells; m = number of words
    fun findWordsSlow(board: Array<CharArray>, words: Array<String>): List<String> {
        return words.filter { word -> word.isNotEmpty() && containsWord(board, word) }
    }

    private fun containsWord(board: Array<CharArray>, word: String): Boolean {
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j] == word[0] && dfs(board, i, j, 0, word)) {
                    return true
                }
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, count: Int, word: String): Boolean {
        if (count == word.length) return true
        if (i !in board.indices || j !in board[i].indices || board[i][j] != word[count]) return false

        val temp = board[i][j]
        board[i][j] = ' '

        val found = dfs(board, i + 1, j, count + 1, word)
                || dfs(board, i, j + 1, count + 1, word)
                || dfs(board, i - 1, j, count + 1, word)
                || dfs(board, i, j - 1, count + 1, word)

        board[i][j] = temp

        return found
    }
}
