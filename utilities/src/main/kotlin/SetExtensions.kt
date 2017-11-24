fun <E> Set<E>.permutations(): Set<List<E>> {
    if (isEmpty()) return emptySet()

    if (size == 1) return setOf(listOf(first()))

    val result = mutableSetOf<List<E>>()

    for (element in this) {
        (this - element).permutations().forEach {
            val resultList = mutableListOf(element)
            resultList.addAll(it)
            result.add(resultList)
        }
    }

    return result
}

fun <E> Set<E>.powerSet(): Set<Set<E>> {
    return when (size) {
        0 -> setOf(emptySet())
        1 -> setOf(this, emptySet())
        else -> {
            val anyElement = iterator().next()

            val exclusiveRemainderPowerSet = minus(anyElement).powerSet()

            val inclusiveRemainderPowerSet = emptySet<Set<E>>().toMutableSet()
            exclusiveRemainderPowerSet.mapTo(inclusiveRemainderPowerSet) { it.union(setOf(anyElement)) }

            return exclusiveRemainderPowerSet.union(inclusiveRemainderPowerSet)
        }
    }
}
