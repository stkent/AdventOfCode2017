@file:Suppress("unused")

fun CharSequence.characterCounts(): Map<Char, Int> = groupBy { it }.mapValues { it.value.size }

fun CharSequence.allDistinct(): Boolean {
  check(isNotEmpty()) { "This method cannot be called on empty CharSequences." }
  return length == toSet().size
}

fun CharSequence.allMatch(): Boolean {
  check(isNotEmpty()) { "This method cannot be called on empty CharSequences." }
  return toSet().size == 1
}

fun CharSequence.anyMatch(): Boolean {
  check(isNotEmpty()) { "This method cannot be called on empty CharSequences." }
  return !allDistinct()
}
