package contests.kotlinheroes4

fun main(args: Array<String>) {
    // 3 4 5
    //1 5 1 5 5
    val bookList = intArrayOf(1, 5, 1, 5, 5)
    println(SpringCleaning.organizationCost(3, 4, 5, bookList, 0))
}

object SpringCleaning {

    // Fail.
    fun organizationCost(maxPerShelf: Int, costToStoreShelf: Int, costToReshuffle: Int, bookList: IntArray, totalCost: Int): Int {
        val n = bookList.size
        if (isOrganized(maxPerShelf, bookList)) return totalCost
        // do op1
        var costOp1 = 0
        val bookShelfCopy = bookList.copyOf()
        storeShelf(bookShelfCopy)
        if (isOrganized(maxPerShelf, bookShelfCopy)) {
            costOp1 += costToStoreShelf
        }
        // do op2
        var costOp2 = 0
        if (bookList.sum() < n * maxPerShelf) {
            val bookShelfCopy2 = bookList.copyOf()
            reshuffle(maxPerShelf, bookShelfCopy2)
            if (isOrganized(maxPerShelf, bookShelfCopy2)) {
                costOp2 += costToReshuffle
            }
        }
        if (costOp1 != 0 && costOp2 != 0) {
            return totalCost + Math.min(costOp1, costOp2)
        } else if (costOp1 == 0 && costOp2 == 0) {
            // try op1 && op2
            var cost3 = 0
            val bookShelfCopy3 = bookList.copyOf()
            storeShelf(bookShelfCopy3)
            cost3 += costToStoreShelf
            if (bookShelfCopy3.sum() < n * maxPerShelf) {
                reshuffle(maxPerShelf, bookShelfCopy3)
                cost3 += costToReshuffle
            }
            val try1Cost = organizationCost(maxPerShelf, costToStoreShelf, costToReshuffle, bookShelfCopy3, totalCost + cost3)
            // try op2 && op1

            var cost4 = 0
            val bookShelfCopy4 = bookList.copyOf()
            if (bookShelfCopy3.sum() < n * maxPerShelf) {
                reshuffle(maxPerShelf, bookShelfCopy3)
                cost4 += costToReshuffle
            }
            storeShelf(bookShelfCopy4)
            cost4 += costToStoreShelf
            val try2Cost = organizationCost(maxPerShelf, costToStoreShelf, costToReshuffle, bookShelfCopy3, totalCost + cost4)

            return Math.min(try1Cost, try2Cost)
        } else {
            return totalCost + Math.max(costOp1, costOp2)
        }
    }

    private fun reshuffle(maxPerShelf: Int, bookList: IntArray) {
        val sum = bookList.sum()
        val n = bookList.size
        val remainingBooks = sum % n
        if (remainingBooks == 0) {
            val booksPerShelf = sum / n
            for (i in bookList.indices) {
                bookList[i] = booksPerShelf
            }
        } else {
            var distributedBooks = 0
            for (i in 0 until bookList.lastIndex) {
                bookList[i] = maxPerShelf
                distributedBooks += maxPerShelf
            }
            bookList[bookList.lastIndex] = sum - distributedBooks
        }
    }

    private fun storeShelf(bookList: IntArray) {
        var max = -1
        var indexOfMax = 0
        bookList.forEachIndexed { index, num ->
            if (num > max) {
                max = num
                indexOfMax = index
            }
        }
        bookList[indexOfMax] = 0
    }

    private fun isOrganized(maxPerShelf: Int, bookList: IntArray): Boolean {
        return bookList.all { it < maxPerShelf }
    }
}