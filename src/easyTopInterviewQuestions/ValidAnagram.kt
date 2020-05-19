package easyTopInterviewQuestions

fun main(args: Array<String>) {
    val s = "anagram"
    val t = "nagaram"
    println(ValidAnagram.isAnagram(s, t))
}

object ValidAnagram {

    // too lazy to do a proper anagram check with hash table
    fun isAnagram(s: String, t: String): Boolean {
        val sortedS = s.toCharArray().sorted()
        val sortedT = t.toCharArray().sorted()

        return sortedS == sortedT
    }
}