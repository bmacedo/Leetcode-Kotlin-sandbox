package practice.kotlinHeroesPractice

/**
 * Alice, Bob and Candies
 *
 * There are 𝑛 candies in a row, they are numbered from left to right from 1 to 𝑛.
 * The size of the 𝑖-th candy is 𝑎𝑖.
 *
 * Alice and Bob play an interesting and tasty game: they eat candy.
 * Alice will eat candy from left to right, and Bob — from right to left.
 * The game ends if all the candies are eaten.
 *
 * The process consists of moves. During a move, the player eats one or more sweets from her/his
 * side (Alice eats from the left, Bob — from the right).
 *
 * Alice makes the first move. During the first move, she will eat 1 candy (its size is 𝑎1).
 * Then, each successive move the players alternate — that is, Bob makes the second move, then Alice,
 * then again Bob and so on.
 *
 * On each move, a player counts the total size of candies eaten during the current move.
 * Once this number becomes strictly greater than the total size of candies eaten by the other player
 * on their previous move, the current player stops eating and the move ends.
 * In other words, on a move, a player eats the smallest possible number of candies such that the sum
 * of the sizes of candies eaten on this move is strictly greater than the sum of the sizes of candies
 * that the other player ate on the previous move.
 * If there are not enough candies to make a move this way, then the player eats up all the remaining
 * candies and the game ends.
 *
 * Print the number of moves in the game and two numbers:
 * 𝑎 — the total size of all sweets eaten by Alice during the game;
 * 𝑏 — the total size of all sweets eaten by Bob during the game.
 */
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    repeat(n) {
        val candies = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").mapNotNull { it.toIntOrNull() }
        AliceBobAndCandies.game(arr.toMutableList())
    }
}

object AliceBobAndCandies {
    fun game(arr: MutableList<Int>) {
        var moves = 0
        var candiesEatenByAlice = 0
        var candiesEatenByBob = 0
        var candiesEatenLastTurn = 0
        var isAliceTurn = true
        while (arr.isNotEmpty()) {
            if (isAliceTurn) {
                // calc alice turn
                var candiesEatenThisTurn = arr.first()
                arr.removeAt(0)
                while (arr.isNotEmpty() && candiesEatenThisTurn < candiesEatenLastTurn + 1) {
                    candiesEatenThisTurn += arr.first()
                    arr.removeAt(0)
                }
                candiesEatenLastTurn = candiesEatenThisTurn
                candiesEatenByAlice += candiesEatenThisTurn
                isAliceTurn = false
            } else {
                // calc bob turn
                var candiesEatenThisTurn = arr.last()
                arr.removeAt(arr.lastIndex)
                while (arr.isNotEmpty() && candiesEatenThisTurn < candiesEatenLastTurn + 1) {
                    candiesEatenThisTurn += arr.last()
                    arr.removeAt(arr.lastIndex)
                }
                candiesEatenLastTurn = candiesEatenThisTurn
                candiesEatenByBob += candiesEatenThisTurn
                isAliceTurn = true
            }
            moves++
        }
        println("$moves $candiesEatenByAlice $candiesEatenByBob")
    }
}