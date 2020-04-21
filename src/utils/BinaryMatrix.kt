package utils

class BinaryMatrix(private vararg val matrix: IntArray) {
    fun get(x:Int, y:Int):Int = matrix[x][y]
    fun dimensions():List<Int> = listOf(matrix.size, if (matrix.isEmpty()) 0 else matrix[0].size)
}