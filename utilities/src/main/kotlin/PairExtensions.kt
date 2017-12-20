@file:Suppress("unused")

fun <T : Comparable<T>> Pair<T, T>.max() = maxOf(first, second)
fun <T : Comparable<T>> Pair<T, T>.min() = minOf(first, second)

fun <T, U> Pair<T, U>.flip() = Pair(second, first)
