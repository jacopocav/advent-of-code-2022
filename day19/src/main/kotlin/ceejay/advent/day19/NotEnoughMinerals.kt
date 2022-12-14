package ceejay.advent.day19

import ceejay.advent.util.InputFile
import ceejay.advent.util.timed

fun main() {
    part1().also {
        println("Part 1 Result: $it")
    }
    part2().also {
        println("Part 2 Result: $it")
    }
}

fun part1() = InputFile.withLines {
    timed {
        map { Blueprint.parse(it) }
            .sumOf { blueprint ->
                val outcome =
                    BlueprintExecutor(blueprint).findBestGeodeProducingPath(maxMinutes = 24)
                outcome.geodes * blueprint.id
            }
    }
}

fun part2() = InputFile.withLines {
    timed {
        map { Blueprint.parse(it) }
            .take(3)
            .map { blueprint ->
                BlueprintExecutor(blueprint).findBestGeodeProducingPath(maxMinutes = 32).geodes
            }.reduce { a, b -> a * b }
    }
}