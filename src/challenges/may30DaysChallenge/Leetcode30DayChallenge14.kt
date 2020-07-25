package challenges.may30DaysChallenge

/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 */
fun main(args: Array<String>) {
    val trie = Trie()

    trie.insert("apple")
    assert(trie.search("apple")) // returns true

    assert(!trie.search("app"))// returns false

    assert(trie.startsWith("app")) // returns true

    trie.insert("app")
    assert(trie.search("app")) // returns true

}

internal class TrieNode {
    // 26 links to node children, because we're assuming only lowercase letters
    private val links: Array<TrieNode?> = arrayOfNulls(26)
    var isEnd = false
        private set

    fun containsKey(char: Char): Boolean = links[char - 'a'] != null

    operator fun get(char: Char): TrieNode? = links[char - 'a']

    fun put(ch: Char, node: TrieNode?) {
        links[ch - 'a'] = node
    }

    fun setEnd() {
        isEnd = true
    }
}

internal class Trie {

    private var root = TrieNode()

    // Inserts a word into the trie.
    // O(m) time, O(m) space, where m is the length of the word.
    fun insert(word: String) {
        var node = root
        for (char in word) {
            if (!node.containsKey(char)) {
                node.put(char, TrieNode())
            }
            node = node[char]!!
        }
        node.setEnd()
    }

    // Returns if the word is in the trie
    // O(m) time, O(1) space
    fun search(word: String): Boolean {
        val node = searchPrefix(word)
        return node != null && node.isEnd
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    // O(m) time, O(1) space
    fun startsWith(prefix: String): Boolean = searchPrefix(prefix) != null

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private fun searchPrefix(word: String): TrieNode? {
        var node = root
        for (char in word) {
            if (node.containsKey(char)) {
                node = node[char]!!
            } else {
                return null
            }
        }
        return node
    }

}

