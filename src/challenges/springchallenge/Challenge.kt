import java.util.*
import java.io.*
import java.lang.Math.floorMod
import java.math.*

/**
 * Grab the pellets as fast as you can!
 **/
fun main(args : Array<String>) {
    val input = Scanner(System.`in`)
    val width = input.nextInt() // size of the grid
    val height = input.nextInt() // top left corner is (x=0, y=0)
    val matrix = mutableListOf<String>()
    var destX: Int? = null
    var destY: Int? = null
    var previousX = 0
    var previousY = 0

    if (input.hasNextLine()) {
        input.nextLine()
    }

    for (i in 0 until height) {
        val row = input.nextLine() // one line of the grid: space " " is floor, pound "#" is wall
        matrix.add(row)
    }

    // game loop
    while (true) {
        val myScore = input.nextInt()
        val opponentScore = input.nextInt()
        val visiblePacCount = input.nextInt() // all your pacs and enemy pacs in sight
        var myX = 0
        var myY = 0

        for (i in 0 until visiblePacCount) {
            val pacId = input.nextInt() // pac number (unique within a team)
            val mine = input.nextInt() != 0 // true if this pac is yours
            val x = input.nextInt() // position in the grid
            val y = input.nextInt() // position in the grid
            val typeId = input.next() // unused in wood leagues
            val speedTurnsLeft = input.nextInt() // unused in wood leagues
            val abilityCooldown = input.nextInt() // unused in wood leagues

            if (mine) {
                myX = x
                myY = y
            }
        }

        var moveX: Int? = null
        var moveY: Int? = null
        var minDist = 999999
        var maxValue = 0
        val visiblePelletCount = input.nextInt() // all pellets in sight
        val nodeList = mutableListOf<Node>()

        for (i in 0 until visiblePelletCount) {
            val x = input.nextInt()
            val y = input.nextInt()
            val value = input.nextInt() // amount of points this pellet is worth
            val dist = Math.abs(myX - x) + Math.abs(myY - y)

            val node = Node(ranking = value - dist, x = x, y = y)
            nodeList.add(node)
        }

//        nodeList.sortByDescending { it.ranking }
//        moveX = nodeList.first().x
//        moveY = nodeList.first().y

        // Write an action using println()
        // To debug: System.err.println("Debug messages...");

        if (myX == previousX && myY == previousY) {
            nodeList.shuffle()
            destX = null
            destY = null
        } else {
            nodeList.sortByDescending { it.ranking }
        }
        moveX = nodeList.first().x
        moveY = nodeList.first().y

        if (destX == null || (myX == destX && myY == destY)) {
            destX = moveX
            destY = moveY
        }

        println("MOVE 0 $destX $destY") // MOVE <pacId> <x> <y>

        previousX = myX
        previousY = myY
    }
}

data class Node(val ranking: Int, val x: Int, val y: Int)