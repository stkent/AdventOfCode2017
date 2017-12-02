fun <E : Comparable<E>> Pair<E, E>.max() = if (first >= second) first else second
fun <E : Comparable<E>> Pair<E, E>.min() = if (first <= second) first else second
