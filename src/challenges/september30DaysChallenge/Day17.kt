package challenges.september30DaysChallenge

/**
 * Robot Bounded In Circle
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.
 * The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 *
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 */
fun main(args: Array<String>) {
    println(Day17.isRobotBounded("RGL"))
}

object Day17 {
    fun isRobotBounded(instructions: String): Boolean {
        var direction = 0 // 0: north, 1: 90 degrees, 2: 180 degrees, 3: 270 degrees
        var x = 0
        var y = 0

        for (char in instructions) {
            when (char) {
                'L' -> ++direction
                'R' -> --direction
                'G' -> {
                    direction = Math.floorMod(direction, 4)
                    when (direction) {
                        0 -> x++
                        1 -> y--
                        2 -> x--
                        3 -> y++
                    }
                }
            }
        }

        direction = Math.floorMod(direction, 4)
        return direction != 0 || (x == 0 && y == 0)
    }
}