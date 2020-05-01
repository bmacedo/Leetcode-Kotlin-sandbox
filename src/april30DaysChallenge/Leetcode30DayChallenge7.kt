package april30DaysChallenge

fun main(args: Array<String>) {
//    val input = intArrayOf(1,2,3)
//    val input = intArrayOf(1,1,2,2)
//    val input = intArrayOf(1,1,3,3,5,5,7,7)
//    val input = intArrayOf(1,3,2,3,5,0)
//    val input = intArrayOf(2,9,0,7,6,2,7,7,0)
    val input = intArrayOf(0,4,0,2,7,2,1,7)
    println(Leetcode30DayChallenge7.countElements(input))
}

object Leetcode30DayChallenge7 {

    fun countElements(arr: IntArray): Int {
        arr.sort()
        var count = 0
        var precount = 1
        var i = 0
        while (i < arr.lastIndex) {
            while (i < arr.lastIndex && arr[i+1] == arr[i]){
                precount++
                i++
            }
            if (i < arr.lastIndex && arr[i+1] == arr[i] + 1) {
                count += precount
            }
            precount = 1
            i++
        }
        return count
    }
}
