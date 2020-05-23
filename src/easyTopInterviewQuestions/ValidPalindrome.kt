package easyTopInterviewQuestions

/**
 * Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters
 * and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
fun main(args: Array<String>) {
    val input = "race e car"
    println(ValidPalindrome.isPalindrome(input))
}

object ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val originalStr = s.filter { it.isLetterOrDigit() }.toLowerCase()
        val reversedStr = originalStr.reversed()
        return originalStr == reversedStr
    }
}