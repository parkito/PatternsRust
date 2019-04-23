package com.coding.play.tasks

import java.util.*

fun maxMin(operations: Array<String>, x: Array<Int>): Array<Long> {
    val stack = LinkedList<Int>()
    val result = LongArray(operations.size)

    for (i in 0 until operations.size) {
        if (operations[i] == "push") {
            stack.addLast(x[i])
        } else {
            stack.removeFirst()
        }
        val max = stack.max() ?: 0
        val min = stack.min() ?: 0
        result[i] = max.toLong() * min.toLong()
    }

    return result.toTypedArray()
}

fun main() {
    val result = maxMin(arrayOf("push", "push", "push", "pop"), arrayOf(1, 2, 3, 1))
    result.forEach(::println)
}