package com.coding.play.tasks

import java.util.*

val allowedSymbols = arrayOf('[', ']', '{', '}', '(', ')')
val openSymbols = arrayOf('[', '{', '(')

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    parsing(scanner.next())
}

fun parsing(arg: String) {
    val stack = Stack<Pair<Char, Int>>()
    for (i in 0 until arg.length) {
        val c = arg[i]
        if (c !in allowedSymbols) {
            continue
        }
        if (c in openSymbols) {
            stack.push(Pair(c, i + 1))
        } else {
            if (stack.isNotEmpty() && isOppositeTo(stack.peek().first, c)) {
                stack.pop()
            } else {
                println(i + 1)
                return
            }
        }
    }
    if (stack.isEmpty()) {
        println("Success")
    } else {
        println(stack.pop().second)
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