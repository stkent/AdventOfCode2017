class Spreadsheet(rawData: List<String>) {

  private val splitData = rawData.map { row -> row.split("\t").map(String::toInt) }

  val checksum = splitData.sumBy { row -> row.max()!! - row.min()!! }

  val sumOfDivisibleEntries by lazy {
    splitData.sumBy { row ->
      val divisiblePair = row.unorderedPairs().find { it.max()!!.rem(it.min()!!) == 0 }!!
      return@sumBy divisiblePair.max()!! / divisiblePair.min()!!
    }
  }

}
