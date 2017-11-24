fun <E> Collection<E>.permutations(): Set<List<E>> {
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

fun <E> Collection<E>.elementCounts(): Map<E, Int> = groupBy({ it }).mapValues { it.value.size }

fun <E> Collection<E>.highestFrequencyElements(): Set<E> {
  if (isEmpty()) return emptySet()

  val elementCounts = elementCounts()
  val highestFrequency = elementCounts.map { it.value }.max()

  return elementCounts()
      .filter { it.value == highestFrequency }
      .map { it.key }
      .toSet()
}

fun <E> Collection<E>.lowestFrequencyElements(): Set<E> {
  if (isEmpty()) return emptySet()

  val elementCounts = elementCounts()
  val lowestFrequency = elementCounts.map { it.value }.min()

  return elementCounts()
      .filter { it.value == lowestFrequency }
      .map { it.key }
      .toSet()
}
