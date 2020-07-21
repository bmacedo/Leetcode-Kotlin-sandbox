package july30DaysChallenge

import utils.asCharMatrix
import utils.print


/**
 *  Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 * those horizontally or vertically neighboring.
 *
 * The same letter cell may not be used more than once.
 */
fun main(args: Array<String>) {
    val input = """
        A B C E
        S F C S
        A D E E
        """.trimIndent().asCharMatrix()
    input.print()
    println(Leetcode30DayChallenge21.exist(input, "ABCCED"))
}


object Leetcode30DayChallenge21 {

    // O(n square) time, O(n square) space, n = # of cells
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (findWord(board, i, j, word, 0)) return true
            }
        }
        return false
    }

    private fun findWord(board: Array<CharArray>, i: Int, j: Int, word: String, index: Int): Boolean {
        if (i !in board.indices || j !in board[i].indices || index !in word.indices) return false

        if (board[i][j] == word[index]) {
            board[i][j] = ' ' // mark as visited to avoid counting twice
            val result = if (index == word.lastIndex) true
            else findWord(board, i + 1, j, word, index + 1)
                    || findWord(board, i - 1, j, word, index + 1)
                    || findWord(board, i, j + 1, word, index + 1)
                    || findWord(board, i, j - 1, word, index + 1)

            board[i][j] = word[index] // undo change
            return result
        }
        return false
    }
}
