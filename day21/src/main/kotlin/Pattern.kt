data class Pattern(val rows: List<String>) {

  val size = rows.size

  val onCount = rows.sumBy { rawRow -> rawRow.count { it == '#' } }

  fun permutations(): Set<Pattern> {
    return setOf(this, flippedH(), flippedV())
        .flatMap { pattern ->
          (0..3).accumulate(pattern) { previous, _ ->
            previous.rotated()
          }
        }.toSet()
  }

  private fun flippedH() = Pattern(rows.map(String::reversed))

  private fun flippedV() = Pattern(rows.reversed())

  // Rotates once clockwise.
  private fun rotated(): Pattern {
    val newRows = (0 until size)
        .map { row -> (0 until size).map { col -> rows[size - 1 - col][row] }.joinToString("") }

    return Pattern(newRows)
  }

}
