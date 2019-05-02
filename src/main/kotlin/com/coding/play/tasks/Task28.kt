package com.coding.play.tasks

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    parsing(args[0])
//    parsing("([](){([])})")
//    parsing("()[]}")
//    parsing("{{[()]]")
}

fun parsing(arg: String) {
    val stack = Stack<Char>()

    for (i in 0 until arg.length) {
        val c = arg[i]
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c)
        } else {
            if (stack.isNotEmpty() && isOppositeTo(stack.peek(), c)) {
                stack.pop()
            } else {
                println(i + 1)
                return
            }
        }
    }
    if (stack.isEmpty()) {
        println("Success")
    }
}

fun isOppositeTo(c1: Char, c2: Char): Boolean {
    return when {
        c1 == '(' && c2 == ')' -> true
        c1 == ')' && c2 == '(' -> true
        c1 == '{' && c2 == '}' -> true
        c1 == '}' && c2 == '{' -> true
        c1 == '[' && c2 == ']' -> true
        c1 == ']' && c2 == '[' -> true
        else -> false
    }
}