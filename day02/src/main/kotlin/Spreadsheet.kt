class Spreadsheet(rawData: List<String>) {

  private val splitData = rawData.map { row -> row.split("\t").map(String::toInt) }

  val checksum = splitData.sumBy { row -> row.max()!! - row.min()!! }

  val sumOfDivisibleEntries = splitData.sumBy { row ->
    val divisiblePair = row.pairs().find { it.max().rem(it.min()) == 0 }!!
    return@sumBy divisiblePair.max() / divisiblePair.min()
  }

}

fun <E> Collection<E>.pairs(): Set<Pair<E, E>> {
  require(size >= 2) { "This method can only be called on collections containing at least 2 elements." }

  if (size == 2) return setOf(Pair(first(), last()))

  val head = first()
  val tail = drop(1)
  return tail.map { Pair(head, it) }.union(tail.pairs())
}

fun <E : Comparable<E>> Pair<E, E>.max() = if (first > second) first else second
fun <E : Comparable<E>> Pair<E, E>.min() = if (first < second) first else second
