package thirtyDaysChallenge

import java.util.*
import kotlin.test.assertEquals


/**
 * LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * -    get(key) - Get the value (will always be positive) of the key if the
 *      key exists in the cache, otherwise return -1.
 *
 * -    put(key, value) - Set or insert the value if the key is not already
 *      present. When the cache reached its capacity, it should invalidate the
 *      least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up: Could you do both operations in O(1) time complexity?
 */
fun main(args: Array<String>) {
    val capacity = 2
    val cache = LRUCache(capacity)
    cache.put(1, 1)
    cache.put(2, 2)
    assertEquals(1, cache.get(1))
    cache.put(3, 3)    // evicts key 2
    assertEquals(-1, cache.get(2))
    cache.put(4, 4)    // evicts key 1
    assertEquals(-1, cache.get(1))
    assertEquals(3, cache.get(3))
    assertEquals(4, cache.get(4))
}

class LRUCache(private val _size: Int) : LinkedHashMap<Int, Int>(_size, 0.75f, true) {

    override fun get(key: Int): Int = super.get(key) ?: -1

    override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>): Boolean = size > _size
}
