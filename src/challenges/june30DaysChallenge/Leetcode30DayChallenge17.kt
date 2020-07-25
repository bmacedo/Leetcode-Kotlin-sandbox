package challenges.june30DaysChallenge

import utils.asCharMatrix
import utils.print


/**
 * Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board
 * are not flipped to 'X'.
 *
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped
 * to 'X'.
 *
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
fun main(args: Array<String>) {
//    val input = """
//        O X X O X
//        X O O X O
//        X O X O X
//        O X O O O
//        X X O X O
//        """.trimIndent().asCharMatrix()
/*
[
    ["O","X","X","O","X"],
    ["X","X","X","X","O"],
    ["X","X","X","O","X"],
    ["O","X","O","O","O"],
    ["X","X","O","X","O"]
]
 */

//    val input = """
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        """.trimIndent().asCharMatrix()

//    val input = """
//        0 X 0
//        X O X
//        0 X O
//        """.trimIndent().asCharMatrix()

    val input = """
        O O O O X X
        O O O O O O
        O X O X O O
        O X O O X O
        O X O X O O
        O X O O O O
        """.trimIndent().asCharMatrix()

//    ["O","O","O","O","X","X"],
//    ["O","O","O","O","O","O"],
//    ["O","X","O","X","O","O"],
//    ["O","X","O","O","X","O"],
//    ["O","X","O","X","O","O"],
//    ["O","X","O","O","O","O"]]

    Leetcode30DayChallenge17.solve(input)

    input.print()
}

object Leetcode30DayChallenge17 {

    fun solve(board: Array<CharArray>) {
        if (board.isEmpty()) return
        val rows: Int = board.size
        val cols: Int = board[0].size
        val visited = Array(rows) { BooleanArray(cols) }

        for (j in 0 until cols) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, visited, false)
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j, visited, false)
            }
        }

        for (i in 0 until rows) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited, false)
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1, visited, false)
            }
        }

        for (i in 1 until rows - 1) {
            for (j in 1 until cols - 1) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, visited, true)
                }
            }
        }
    }

    private fun dfs(board: Array<CharArray>, row: Int, col: Int, visited: Array<BooleanArray>, flip: Boolean) {
        if (row < 0 || col < 0 || row > board.size - 1 || col > board[0].size - 1) return
        if (visited[row][col]) return
        if (board[row][col] == 'X') return
        if (flip) board[row][col] = 'X'

        visited[row][col] = true
        dfs(board, row + 1, col, visited, flip)
        dfs(board, row - 1, col, visited, flip)
        dfs(board, row, col + 1, visited, flip)
        dfs(board, row, col - 1, visited, flip)
    }


}