class Enhancer(rawTransforms: List<String>) {
  
  private val transforms = rawTransforms
      .flatMap { rawTransform ->
        val rows = rawTransform.split(" => ").map { it.split('/') }
        val oldPattern = Pattern(rows[0])
        val newPattern = Pattern(rows[1])
        return@flatMap oldPattern.permutations().map { it to newPattern }
      }
      .toMap()

  fun enhance(seed: List<String>, repeats: Int): Pattern {
    var image = Pattern(seed)
    repeat(repeats) { image = enhance(image) }
    return image
  }

  private fun enhance(currentImage: Pattern): Pattern {
    val splitSize = if (currentImage.size.rem(2) == 0) 2 else 3

    val newRows = currentImage.rows.chunked(splitSize)
                                   .map(::patternsFromStrings)
                                   .map { patterns -> patterns.map { transforms[it]!! } }
                                   .flatMap(::stringsFromPatterns)

    return Pattern(newRows)
  }

  private fun patternsFromStrings(rows: List<String>): List<Pattern> {
    val splitSize = rows.size

    return (0 until rows[0].length step splitSize)
        .map { rowIndex -> rows.map { it.slice(rowIndex until rowIndex + splitSize) } }
        .map { Pattern(it) }
  }

  private fun stringsFromPatterns(patterns: List<Pattern>): List<String> {
    val splitSize = patterns[0].size
    val initial = List(splitSize + 1) { "" }

    return patterns.fold(initial) { list, pattern ->
      list.zip(pattern.rows, String::plus)
    }
  }

}
