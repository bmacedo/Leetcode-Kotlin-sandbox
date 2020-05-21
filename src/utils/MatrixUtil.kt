package utils

fun String.asIntMatrix(): Array<IntArray> = this.split(",\n")
        .map { line ->
            line.split(",", "]", "[")
                    .mapNotNull { it.toIntOrNull() }
                    .toIntArray()
        }.toTypedArray()

fun Array<IntArray>.print() {
    forEach { row ->
        row.forEach { item ->
            print("$item\t")
        }
        println()
    }
}

fun Array<CharArray>.print() {
    forEach { row ->
        row.forEach { item ->
            print("$item\t")
        }
        println()
    }
}