package com.coding.play.tasks

//Напишите программу, которая считывает число и выводит "F",
// если оно является одним из десяти первых чисел Фибоначчи (от 1 до 55 включительно),
// иначе "T", если оно является одним из десяти первых треугольных чисел
// (от 0 до 45 включительно), иначе "P", если оно является какой-либо
// положительной степенью целого числа 10 (меньше 106 ) и "N" в противном случае.
//
//Гарантируется, что число положительное.
fun main() {
    isFibFirstTen(100)
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

fun isTriangleFirstTen(num: Int) {

}

fun isNumDegree() {

}
