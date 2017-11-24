import java.util.Comparator

fun <K> Collection<K>.elementCounts(): Map<K, Int> = groupBy({ it }).mapValues { it.value.size }

fun <T : Comparable<T>> Collection<T>.highestFrequencyElement(tieBreaker: Comparator<T>): T {
    return elementCounts()
            .entries
            .toSortedSet(
                    compareByDescending(selector = Map.Entry<T, Int>::value)
                            .thenBy(selector = Map.Entry<T, Int>::key, comparator = tieBreaker)
            )
            .first()
            .key
}

fun <T : Comparable<T>> Collection<T>.lowestFrequencyElement(tieBreaker: Comparator<T>): T {
    return elementCounts()
            .entries
            .toSortedSet(
                    compareBy(selector = Map.Entry<T, Int>::value)
                            .thenBy(selector = Map.Entry<T, Int>::key, comparator = tieBreaker)
            )
            .first()
            .key
}
