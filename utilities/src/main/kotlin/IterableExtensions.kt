// Adapted from stdlib proposal: https://youtrack.jetbrains.com/issue/KT-7657#comment=27-2602841
fun <T, R> Iterable<T>.accumulate(initial: R, operation: (previous: R, current: T) -> R): List<R> {
  val result = mutableListOf(initial)
  for (element in this) result.add(operation(result.last(), element))
  return result
}
