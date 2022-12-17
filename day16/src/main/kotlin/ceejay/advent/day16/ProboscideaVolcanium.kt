package ceejay.advent.day16

import ceejay.advent.util.InputFile

fun main() {
    println("Part 1 Result: ${part1()}")
//    println("Part 2 Result: ${part2()}")
}

fun part1(): Int = InputFile.withLines {
    val startValve = "AA"

    parse()
        .prune(startValve = startValve)
        .findBestPath(startValve, 30)
        .totalRelievedPressure
}

fun part2(): Long = InputFile.useLines {
    TODO()
}