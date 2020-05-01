package april30DaysChallenge


/**
 * Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically.
 *
 * You may assume all four edges of the grid are all surrounded by water.
 */
fun main(args: Array<String>) {
    // expect: 58
    val input = arrayOf(
            "10011101100000000000".toCharArray(),
            "10011001000101010010".toCharArray(),
            "00011110101100001010".toCharArray(),
            "00011001000111001001".toCharArray(),
            "00000001110000000000".toCharArray(),
            "10000101011000000101".toCharArray(),
            "00010001010101010101".toCharArray(),
            "00010100110101101110".toCharArray(),
            "00001001100001000101".toCharArray(),
            "00100100000100100010".toCharArray(),
            "10010000000100101010".toCharArray(),
            "01000101011011101100".toCharArray(),
            "11010000100000010001".toCharArray(),
            "01001110001111101000".toCharArray(),
            "00111000110001010000".toCharArray(),
            "10010100001000101011".toCharArray(),
            "10100000010001010000".toCharArray(),
            "01100011101010111100".toCharArray(),
            "01000011001010010011".toCharArray(),
            "00000011110100011000".toCharArray()
    )

    println(Leetcode30DayChallenge17.numIslands(input))
}

object Leetcode30DayChallenge17 {

    private val LAND = '1'

    fun numIslands(grid: Array<CharArray>): Int {
        var numIslands = 0
        for (rowIndex in grid.indices) {
            for (columnIndex in grid[rowIndex].indices) {
                if (grid[rowIndex][columnIndex] == LAND) {
                    val currentPosition = Pair(rowIndex, columnIndex)
                    numIslands += visitIsland(grid, currentPosition)
                }
            }
        }
        return numIslands
    }

    private fun visitIsland(grid: Array<CharArray>, currentPosition: Pair<Int, Int>): Int {
        if (isInsideGrid(grid, currentPosition)) {
            val rowIndex = currentPosition.first
            val columnIndex = currentPosition.second
            if (grid[rowIndex][columnIndex] == LAND) {
                grid[currentPosition.first][currentPosition.second] = '0'
                visitIsland(grid, Pair(rowIndex + 1, columnIndex))
                visitIsland(grid, Pair(rowIndex - 1, columnIndex))
                visitIsland(grid, Pair(rowIndex, columnIndex + 1))
                visitIsland(grid, Pair(rowIndex, columnIndex - 1))
                return 1
            }
        }
        return 0
    }

    private fun isInsideGrid(grid: Array<CharArray>, pair: Pair<Int, Int>): Boolean {
        return pair.first in grid.indices && pair.second in grid[pair.first].indices
    }

//    fun numIslandsFailed2(grid: Array<CharArray>): Int {
//        val graphs = mutableListOf<MutableSet<Pair<Int, Int>>>()
//
//        for (rowIndex in grid.indices) {
//            for (columnIndex in grid[rowIndex].indices) {
//                if (grid[rowIndex][columnIndex] == LAND) {
//                    val currentPair = Pair(rowIndex, columnIndex)
//                    var wasAdded = false
//                    graphs.forEach { graph ->
//                        val updatedGraph = graph.toMutableList()
//                        graph.forEach { vertex ->
//                            if (isAdjacent(grid, vertex, currentPair)) {
//                                updatedGraph.add(currentPair)
//                                wasAdded = true
//                            }
//                        }
//                        graph.addAll(updatedGraph)
//                    }
//
//                    if (!wasAdded) {
//                        graphs.add(mutableSetOf(currentPair))
//                    }
//                }
//            }
//        }
//
//        var i = 0
//        while (i < graphs.size - 1) {
//            val graph1 = graphs[i]
//            val graph2 = graphs[i + 1]
//            if (areAdjacent(grid, graph1, graph2)) {
//                val graph = (graph1 + graph2).toMutableSet()
//                graphs.remove(graph1)
//                graphs.remove(graph2)
//                graphs.add(graph)
//            } else {
//                i++
//            }
//        }
//        return graphs.size
//    }
//
//    private fun areAdjacent(grid: Array<CharArray>, graph1: MutableSet<Pair<Int, Int>>, graph2: MutableSet<Pair<Int, Int>>): Boolean {
//        graph1.forEach { vertex ->
//            graph2.forEach { vertex2 ->
//                if (isAdjacent(grid, vertex, vertex2)) {
//                    return true
//                }
//            }
//        }
//        return false
//    }
//
//    private fun isAdjacent(grid: Array<CharArray>, vertex: Pair<Int, Int>, pair: Pair<Int, Int>): Boolean {
//        val rowIndex = vertex.first
//        val columnIndex = vertex.second
//
//        val bottomPair = Pair(rowIndex + 1, columnIndex)
//        val rightPair = Pair(rowIndex, columnIndex + 1)
//        val leftPair = Pair(rowIndex, columnIndex - 1)
//        val topPair = Pair(rowIndex - 1, columnIndex)
//
//        return (isInsideGrid(grid, bottomPair) && bottomPair == pair) ||
//                (isInsideGrid(grid, rightPair) && rightPair == pair) ||
//                (isInsideGrid(grid, leftPair) && leftPair == pair) ||
//                (isInsideGrid(grid, topPair) && topPair == pair)
//    }

//    private fun isLand(grid: Array<CharArray>, pair: Pair<Int, Int>): Boolean {
//        if (pair.first in grid.indices && pair.second in grid[pair.first].indices) {
//            return grid[pair.first][pair.second] == LAND
//        }
//        return false
//    }

//    fun numIslandsFailed(grid: Array<CharArray>): Int {
//        val hashMap = HashMap<Pair<Int,Int>, List<Pair<Int,Int>>>()
//        val leafs = mutableSetOf<Pair<Int,Int>>()
//        for (rowIndex in grid.indices) {
//            for (columnIndex in grid[rowIndex].indices) {
//                if (grid[rowIndex][columnIndex] == LAND) {
//                    val currentPair = Pair(rowIndex, columnIndex)
//                    val myConnections = pairsConnectedTo(hashMap, currentPair)
//                    val bottomPair = Pair(rowIndex + 1, columnIndex)
//                    val rightPair = Pair(rowIndex, columnIndex + 1)
//                    val leftPair = Pair(rowIndex, columnIndex - 1)
//                    val topPair = Pair(rowIndex - 1, columnIndex)
//                    var connected = false
//                    if (canConnectTo(grid, myConnections, bottomPair)) {
//                        currentPair.addConnectionTo(hashMap, bottomPair)
//                        connected = true
//                    }
//                    if (canConnectTo(grid, myConnections, rightPair)) {
//                        currentPair.addConnectionTo(hashMap, rightPair)
//                        connected = true
//                    }
//                    if (canConnectTo(grid, myConnections, leftPair)) {
//                        currentPair.addConnectionTo(hashMap, leftPair)
//                        connected = true
//                    }
//                    if (canConnectTo(grid, myConnections, topPair)) {
//                        currentPair.addConnectionTo(hashMap, topPair)
//                        connected = true
//                    }
//                    if (!connected) {
//                        leafs.add(currentPair)
//                    }
//
////                    when {
////                        canConnectTo(grid, myConnections, bottomPair) -> hashMap[currentPair] = bottomPair
////                        canConnectTo(grid, myConnections, rightPair) -> hashMap[currentPair] = rightPair
////                        canConnectTo(grid, myConnections, leftPair) -> hashMap[currentPair] = leftPair
////                        canConnectTo(grid, myConnections, topPair) -> hashMap[currentPair] = topPair
////                        else -> islandCount++
////                    }
//                }
//            }
//
//        }
//
//        for (rowIndex in grid.indices) {
//            for (columnIndex in grid[rowIndex].indices) {
//                if (grid[rowIndex][columnIndex] == LAND) {
//                    val currentPair = Pair(rowIndex, columnIndex)
//                    val myConnections = pairsConnectedTo(hashMap, currentPair)
//                    if (myConnections.isEmpty()) leafs.add(currentPair)
//                }
//            }
//        }
//
//        return leafs.size
//    }
//
//    private fun Pair<Int, Int>.canReachAnyLeaf(hashMap: HashMap<Pair<Int, Int>, List<Pair<Int, Int>>>, roots: Set<Pair<Int, Int>>): Boolean {
//        val currentConnections = mutableSetOf<Pair<Int, Int>>()
//        currentConnections.addAll(pairsConnectedTo(hashMap, this))
//        while (currentConnections.isNotEmpty()) {
//            val connectedPair = currentConnections.first()
//            if (roots.contains(connectedPair)) {
//                return true
//            } else {
//                currentConnections.addAll(pairsConnectedTo(hashMap, connectedPair))
//            }
//            currentConnections.remove(connectedPair)
//        }
//        return false
//    }
//
//    private fun <B> Pair<B, B>.addConnectionTo(hashMap: HashMap<Pair<B, B>, List<Pair<B, B>>>, bottomPair: Pair<B, B>) {
//        hashMap[this] = hashMap[this]?.plus(bottomPair) ?: mutableListOf(bottomPair)
//    }
//
//    private fun pairsConnectedTo(hashMap: HashMap<Pair<Int, Int>, List<Pair<Int, Int>>>, currentPair: Pair<Int, Int>): List<Pair<Int, Int>> {
//        val list = mutableListOf<Pair<Int,Int>>()
//        hashMap.entries.forEach { (key, value) ->
//            if (value.contains(currentPair)) {
//                list.add(key)
//            }
//        }
//        list.addAll(hashMap[currentPair] ?: emptyList())
//        return list
//    }
//
//    private fun canConnectTo(grid: Array<CharArray>, connections: List<Pair<Int, Int>>?, pair: Pair<Int, Int>): Boolean {
//        // pair is land && pair is not connected to me
//        if (isLand(grid, pair)) {
//            return connections == null || !connections.contains(pair)
//        }
//        return false
//    }
//

//    fun numIslands(grid: Array<CharArray>): Int {
//        val hashMap = HashMap<Pair<Int,Int>, Pair<Int,Int>>()
//        for (rowIndex in grid.indices) {
//            for (columnIndex in grid[rowIndex].indices) {
//                if (grid[rowIndex][columnIndex] == LAND) {
//                    // try to find item to the left in the hashmap
//                    val root = if (hashMap.containsKey(Pair(rowIndex, columnIndex - 1))
//                            && grid[rowIndex][columnIndex - 1] == LAND) {
//                        hashMap[Pair(rowIndex, columnIndex - 1)]
//                    } else if (hashMap.containsKey(Pair(rowIndex - 1, columnIndex))
//                            && grid[rowIndex - 1][columnIndex] == LAND) {
//                        hashMap[Pair(rowIndex - 1, columnIndex)]
//                    } else {
//                        Pair(rowIndex, columnIndex)
//                    }
//                    hashMap[Pair(rowIndex, columnIndex)] = root!!
//                }
//            }
//        }
//
//        return hashMap.values.distinct().size
//    }

    // if found, add yourself to the hashmap, copying the root from the
    // found item
    // else
    // try to find item to the top in the hashmap
    // if found. add yourself to the hashmap, copying the root from the
    // found item
    // else
    // add yourself to the hashmap, root is yourself

//    fun numIslands(grid: Array<CharArray>): Int {
//        val hash = HashSet<Pair<Int, Int>>()
//        for (rowIndex in grid.indices) {
//            for (columnIndex in grid[rowIndex].indices) {
//                if (grid[rowIndex][columnIndex] == LAND) {
//                    val root = if (hash.isEmpty()) {
//                        Pair(rowIndex, columnIndex)
//                    } else {
//                        findRoot(rowIndex, columnIndex, grid)
//                    }
//                    hash.add(root)
//                }
//            }
//        }
//
//        return hash.size
//    }
//
//    // Searches for topmost leftmost '1'
//    private fun findRoot(rowIndex: Int, columnIndex: Int, grid: Array<CharArray>): Pair<Int, Int> {
//        var topMostIndex = rowIndex
//        var leftMostIndex = columnIndex
//
//        while (true) {
//            if (topMostIndex - 1 in grid.indices && grid[topMostIndex - 1][leftMostIndex] == LAND) {
//                topMostIndex -= 1
//                continue
//            }
//            if (leftMostIndex - 1 in grid[topMostIndex].indices && grid[topMostIndex][leftMostIndex - 1] == LAND) {
//                leftMostIndex -= 1
//                continue
//            }
//            break
//        }
//
//        return Pair(topMostIndex, leftMostIndex)
//    }

}
