package com.peto.canopy.io

import java.io.File
import java.net.URL

/**
 * good read
 * https://stackoverflow.com/questions/3861989/preferred-way-of-loading-resources-in-java
 */
fun main() {
//   readFileLineByLineUsingForEachLine("data/some.txt")
//    readFileAsLinesUsingUseLines1("data/some.txt").forEach { println(it)}
//   readFileAsLinesUsingBufferedReader("data/some.txt").forEach { println(it)}
//   readFileAsLinesUsingReadLines("data/some.txt").forEach { println(it) }
    val url: URL? = Thread.currentThread().contextClassLoader.getResource("some.txt")
    println(url)
    println(readFileAsTextUsingInputStream(url?.path ?: ""))
}

fun readFileLineByLineUsingForEachLine(fileName: String) = File(fileName).forEachLine { println(it) }
fun readFileAsLinesUsingUseLines(fileName: String) = File(fileName).useLines { it.toList().forEach { s -> println(s) } }
fun readFileAsLinesUsingUseLines1(fileName: String): List<String> = File(fileName).useLines { it.toList() }

fun readFileAsLinesUsingBufferedReader(fileName: String): List<String> = File(fileName).bufferedReader().readLines()
fun readFileAsLinesUsingReadLines(fileName: String): List<String> = File(fileName).readLines()

fun readFileAsTextUsingInputStream(fileName: String) = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)
