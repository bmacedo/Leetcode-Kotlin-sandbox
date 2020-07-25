package practice.easyTopInterviewQuestions

/**
 * Valid Sudoku
 *
 * Determine if a 9x9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * -    Each row must contain the digits 1-9 without repetition.
 * -    Each column must contain the digits 1-9 without repetition.
 * -    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * -    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * -    Only the filled cells need to be validated according to the mentioned rules.
 * -    The given board contain only digits 1-9 and the character '.'.
 * -    The given board size is always 9x9.
 */
fun main(args: Array<String>) {
    val input = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println(ValidSudoku.isValidSudoku(input))
}

object ValidSudoku {

    // Elegant solution. Makes use of the 'add' return result from HashSet
    // to figure out if the element was repeated or not
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in board.indices) {
            val rowCheck = HashSet<Char>()
            val columnCheck = HashSet<Char>()
            val boxCheck = HashSet<Char>()
            for (j in board[i].indices) {
                // check rows
                if (board[i][j] != '.' && !rowCheck.add(board[i][j])) return false
                // check columns
                if (board[j][i] != '.' && !columnCheck.add(board[j][i])) return false
                // check box
                val boxRow = 3 * (i / 3) + (j/3)
                val boxCol = 3 * (i % 3) + (j%3)
                if (board[boxRow][boxCol] != '.' && !boxCheck.add(board[boxRow][boxCol])) return false
            }
        }
        return true
    }

    // This solution is a bit faster because it uses the array of
    // predefined size and the fact that the chars will only be single digits.
    // Probably the most efficient solution.
    fun isValidSudokuWithBooleanArray(board: Array<CharArray>): Boolean {
        val n = board.size
        for (i in board.indices) {
            val rowCheck = BooleanArray(n) { false }
            val columnCheck = BooleanArray(n) { false }
            val boxCheck = BooleanArray(n) { false }
            for (j in board[i].indices) {
                // check rows
                when {
                    board[i][j] == '.' -> { /* no op*/ }
                    rowCheck[board[i][j] - '1'] -> return false
                    else -> rowCheck[board[i][j] - '1'] = true
                }

                // check columns
                when {
                    board[j][i] == '.' -> { /* no op*/ }
                    columnCheck[board[j][i] - '1'] -> return false
                    else -> columnCheck[board[j][i] - '1'] = true
                }

                // check box
                val rowIndex = 3 * (i / 3) + (j/3)
                val colIndex = 3 * (i % 3) + (j%3)
                when {
                    board[rowIndex][colIndex] == '.' -> { /* no op*/ }
                    boxCheck[board[rowIndex][colIndex] - '1'] -> return false
                    else -> boxCheck[board[rowIndex][colIndex] - '1'] = true
                }
            }
        }
        return true
    }

    // O(n) time, O(n) space
    // My initial solution ¯\_(ツ)_/¯
    // This solution uses more space because it doesn't rely on the math
    // to calculate the box boundaries. Because of that it needs to keep
    // all of the boxes in memory.
    fun isValidSudokuSpacey(board: Array<CharArray>): Boolean {
        val submatrix = Array<HashSet<Char>>(9) { HashSet() } // here. waste of space
        for (i in board.indices) {
            val rowSet = HashSet<Char>()
            val columnSet = HashSet<Char>()
            for (j in board[i].indices) {
                if (board[j][i] != '.') {
                    // assert non-repeated digits on any given column
                    if (columnSet.contains(board[j][i])) return false
                    columnSet.add(board[j][i])
                }

                if (board[i][j] != '.') {
                    // assert non-repeated digits on any given row
                    if (rowSet.contains(board[i][j])) return false
                    rowSet.add(board[i][j])

                    // assert non-repeated digits on any 3x3 sub-boxes
                    val subBoxIndex = when {
                        i in 0..2 && j in 0..2 -> 0
                        i in 3..5 && j in 0..2 -> 1
                        i in 6..8 && j in 0..2 -> 2
                        i in 0..2 && j in 3..5 -> 3
                        i in 3..5 && j in 3..5 -> 4
                        i in 6..8 && j in 3..5 -> 5
                        i in 0..2 && j in 6..8 -> 6
                        i in 3..5 && j in 6..8 -> 7
                        i in 6..8 && j in 6..8 -> 8
                        else -> throw RuntimeException("invalid index")
                    }
                    if (submatrix[subBoxIndex].contains(board[i][j])) return false
                    submatrix[subBoxIndex].add(board[i][j])
                }
            }
        }
        return true
    }
}