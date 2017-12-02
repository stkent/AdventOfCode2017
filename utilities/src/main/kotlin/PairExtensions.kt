fun <T : Comparable<T>> Pair<T, T>.max() = if (first >= second) first else second
fun <T : Comparable<T>> Pair<T, T>.min() = if (first <= second) first else second

fun <T, U> Pair<T, U>.flip() = Pair(second, first)
