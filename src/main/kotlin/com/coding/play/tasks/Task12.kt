package com.coding.play.tasks

val scan = java.util.Scanner(System.`in`)
fun main(args: Array<String>) {
    val a = scan.nextInt()
    val b = scan.nextInt()
    val c = scan.nextInt()
    val income = (a + b) / c

    val sale: Double = when (income) {
        in 0..10000 -> 0.5
        in 10000..12000 -> 0.4
        in 12000..16000 -> 0.3
        in 16000..18000 -> 0.2
        in 18000..19999 -> 0.1
        else -> 0.0
    }

    println(10000 * sale.toInt())
}

fun task(args: Array<String>) = println(10_000 * Array(3) { scan.nextInt() }
        .let {
            (it[0] + it[1]) / it[2]
        }
        .let {
            when {
                it < 10_000 -> 5
                it < 12_000 -> 4
                it < 16_000 -> 3
                it < 18_000 -> 2
                it < 20_000 -> 1
                else -> 0
            }
        }
)

fun test2(args: Array<String>) = println(scan.nextDouble().let { Math.sin(it) * Math.cos(it) })