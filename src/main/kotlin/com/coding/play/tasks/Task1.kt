package com.coding.play.tasks

//Напишите программу, которая считывает число и выводит "F",
// если оно является одним из десяти первых чисел Фибоначчи (от 1 до 55 включительно),
// иначе "T", если оно является одним из десяти первых треугольных чисел
// (от 0 до 45 включительно), иначе "P", если оно является какой-либо
// положительной степенью целого числа 10 (меньше 106 ) и "N" в противном случае.
//
//Гарантируется, что число положительное.
fun main() {
    val scan = java.util.Scanner(System.`in`)

    val a = scan.nextInt()

    when {
        isFibFirstTen(a) -> print("F")
        isTriangleFirstTen(a) -> print("T")
        isNumDegree(a) -> print("P")
        else -> print("N")
    }
}

fun isFibFirstTen(num: Int): Boolean {
    var fib = 1
    var prev = 1
    if (num == 1) {
        return true
    }

    for (i in 0..8) {
        if (num == fib) {
            return true
        }
        fib += prev
        prev = fib - prev
    }
    return false
}

fun isTriangleFirstTen(num: Int): Boolean {
    for (i in 0..9) {
        val triNumber = 0.5 * i * (i + 1)
        if (triNumber.toInt() == num) {
            return true
        }
    }
    return false
}

fun isNumDegree(num: Int): Boolean {
    var deg = 1
    for (i in 0..5) {
        if (deg == num) {
            return true
        }
        deg *= 10
    }
    return false
}
