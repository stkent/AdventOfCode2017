@file:Suppress("unused")

import org.apache.commons.collections4.MultiSet
import org.apache.commons.collections4.multiset.HashMultiSet

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

fun <E> Collection<E>.elementCounts(): Map<E, Int> = groupingBy { it }.eachCount()

fun <E> Collection<E>.highestFrequencyElements(): Set<E> {
  if (isEmpty()) return emptySet()

  val elementCounts = elementCounts()
  val highestFrequency = elementCounts.map { it.value }.max()

  return elementCounts
      .filter { it.value == highestFrequency }
      .map { it.key }
      .toSet()
}

fun <E> Collection<E>.lowestFrequencyElements(): Set<E> {
  if (isEmpty()) return emptySet()

  val elementCounts = elementCounts()
  val lowestFrequency = elementCounts.map { it.value }.min()

  return elementCounts
      .filter { it.value == lowestFrequency }
      .map { it.key }
      .toSet()
}


fun <E> Collection<E>.unorderedPairs(): MultiSet<Set<E>> {
  check(size >= 2) { "This method can only be called on collections containing at least 2 elements." }

  val result = HashMultiSet<Set<E>>()

  if (size == 2) {
    result.add(setOf(first(), last()))
    return result
  }

  val head = first()
  val tail = drop(1)
  result.addAll(tail.map { setOf(head, it) })
  result.addAll(tail.unorderedPairs())
  return result
}

fun <E> Collection<E>.orderedPairs(): MultiSet<Pair<E, E>> {
  val unorderedPairs = unorderedPairs()

  val result = HashMultiSet<Pair<E, E>>()

  unorderedPairs.forEach {
    val orderedPair = Pair(it.first(), it.last())
    result.add(orderedPair)
    result.add(orderedPair.flip())
  }

  return result
}

fun <T> Collection<T>.allDistinct(): Boolean {
  check(isNotEmpty()) { "This method cannot be called on empty Collections." }
  return size == toSet().size
}

fun <T> Collection<T>.allMatch(): Boolean {
  check(isNotEmpty()) { "This method cannot be called on empty Collections." }
  return toSet().size == 1
}

fun <T> Collection<T>.anyDistinct(): Boolean {
  check(isNotEmpty()) { "This method cannot be called on empty Collections." }
  return !allMatch()
}

fun <T> Collection<T>.anyMatch(): Boolean {
  check(isNotEmpty()) { "This method cannot be called on empty Collections." }
  return !allDistinct()
}
