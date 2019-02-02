package com.coding.play.tasks

import java.util.stream.LongStream

//Write a method for calculating the sum of odd numbers
// in the given interval (inclusively) using Stream API.
//
//Important. Use the provided template for your method.
// Pay attention to type of an argument and the returned value. Please, don't use cycles

fun sumOfOddNumbersInRange(start: Long, end: Long): Long {
    return LongStream.range(start, end + 1).filter { v -> v % 2 == 1L }.sum()
}