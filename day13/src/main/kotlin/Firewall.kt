class Firewall(scannerInfo: List<String>) {

  data class Layer(val depth: Int)

  data class Scanner(val range: Int) {
    val period = 2 * (range - 1)
  }

  private val scanners = scannerInfo.map { it.split(": ").map(String::toInt) }
                                    .map { Layer(depth = it[0]) to Scanner(range = it[1]) }

  fun scoreForDelay(delay: Int): Int {
    return scanners.filter { (layer, scanner) -> (layer.depth + delay).rem(scanner.period) == 0 }
                   .map    { (layer, scanner) -> layer.depth * scanner.range }
                   .sum()
  }

  fun firstEscapeDelay(): Int {
    return generateSequence(0) { it + 1 }
        .first { delay ->
          scanners.none { (layer, scanner) ->
            (layer.depth + delay).rem(scanner.period) == 0
          }
        }
  }

}
