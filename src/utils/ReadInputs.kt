package utils

fun readLn() = readLine()!! // string line
fun readStrings() = readLn().split(",") // list of strings
fun readInts() = readStrings().map { it.trim().toInt() } // list of ints