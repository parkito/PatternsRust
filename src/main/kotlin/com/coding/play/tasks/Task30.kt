package com.coding.play.tasks

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val scanner = Scanner(System.`in`)
    val bufferSize = scanner.nextInt()
    val numOfPackages = scanner.nextInt()
    val packages = ArrayList<Package>(bufferSize)
    for (i in 0 until numOfPackages) {
        val str = scanner.next().split(" ")
        val arrival = str[0].toInt()
        val duration = str[1].toInt()
        packages.add(Package(i, arrival, duration))
    }
    processPackages(packages,bufferSize)
}

fun processPackages(packages: List<Package>, bufferSize: Int) {

}

class Buffer(val size: Int){

}


data class Package(
        val num: Int,
        val arrival: Int,
        val duration: Int
)