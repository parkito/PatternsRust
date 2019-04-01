package com.coding.play.tasks

import java.util.*
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val sum = scan.nextInt() + scan.nextInt() + scan.nextInt()
    val sumString = sum.toString().toCharArray()
    val temp = sumString[0]
    sumString[0] = sumString[sumString.size - 1]
    sumString[sumString.size - 1] = temp

    print(String(sumString).toInt())
}

fun main3(args: Array<String>) = println(Array(3){scan.nextInt()}.sum().toString().let{
    it.last() + it.substring(1, it.length - 1) + it.first()
}.toInt())