package ceejay.advent.day05

import ceejay.advent.util.InputFile
import ceejay.advent.util.InputFile.newLine

fun main() {
    println("Part 1 Result: ${part1()}")
    println("Part 2 Result: ${part2()}")
}

fun part1(): String {
    return run(::Crate9000)
}

fun part2(): String {
    return run(::Crate9001)
}

fun run(crateCreator: (Cargo) -> Crate): String {
    val input = InputFile()

    val parts = input.split("$newLine$newLine")

    assert(parts.size == 2)

    val cargo = Cargo.parse(parts[0])
    val crate = crateCreator(cargo)

    val moves = parts[1].split(newLine)
        .filter { it.isNotBlank() }
        .map { Move.parse(it) }

    moves.forEach {
        crate.move(it)
    }

    return cargo.peekAll().joinToString(separator = "")
}