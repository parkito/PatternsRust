package com.coding.play.tasks

fun main() {
    val A = scan.next()
    val B = scan.next()
    val result = A.replace(B, "_")
    val times = result.chars()
            .filter { i -> i == 95 }
            .count()
    print("$result $times")
}

fun main1(args: Array<String>) {
    val s = scan.next().replace(scan.next(), "_")
    print("$s ${s.count { c -> c == '_' }}")
}