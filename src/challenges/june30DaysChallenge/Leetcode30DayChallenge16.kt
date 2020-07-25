package challenges.june30DaysChallenge


/**
 * Validate IP Address
 *
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address
 * or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four
 * decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing
 * 16 bits. The groups are separated by colons (":").
 *
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
 *
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters
 * in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6
 * address (Omit leading zeros and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two
 * consecutive colons (::) to pursue simplicity.
 *
 * For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid.
 *
 * For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 */
fun main(args: Array<String>) {
    assert("IPv4" == Leetcode30DayChallenge16.validIPAddress("172.16.254.0"))
    assert("IPv4" == Leetcode30DayChallenge16.validIPAddress("172.16.254.0"))
    assert("Neither" == Leetcode30DayChallenge16.validIPAddress("172.16.254.01"))
    assert("IPv6" == Leetcode30DayChallenge16.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"))
    assert("IPv6" == Leetcode30DayChallenge16.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"))
    assert("IPv6" == Leetcode30DayChallenge16.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
    assert("Neither" == Leetcode30DayChallenge16.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"))
    assert("Neither" == Leetcode30DayChallenge16.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"))
}

object Leetcode30DayChallenge16 {

    fun validIPAddress(IP: String): String {
        return when {
            isIpv4(IP) -> "IPv4"
            isIpv6(IP) -> "IPv6"
            else -> "Neither"
        }
    }

    private fun isIpv4(ip: String): Boolean {
        val p = "(0|[1-9][0-9]{0,2})"
        val regex = "$p\\.$p\\.$p\\.$p".toRegex()
        val matchResult = regex.matchEntire(ip)
        val groups = matchResult?.groups
                ?.drop(1)
                ?.mapNotNull { it?.value?.toInt() }
                ?.filter { it in (0..255) }
        return groups?.size == 4
    }

    private fun isIpv6(ip: String): Boolean {
        val p = "(0|[0-9a-f]{1,4})"
        val regex = "($p:){7}$p".toRegex()
        return regex.matches(ip.toLowerCase())
    }
}