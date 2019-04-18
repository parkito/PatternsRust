package com.coding.play.tasks

fun main(args: Array<String>) {
    val c1 = scan.next()[0]
    val c2 = scan.next()[0]
    print(isCaseEquals(c1, c2))
}

fun isCaseEquals(a: Char, b: Char): Boolean = (a.isUpperCase() && b.isUpperCase()) || (a.isLowerCase() && b.isLowerCase())