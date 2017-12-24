private const val EMPTY_CHAR = ' '

class Router {

  data class Result(val chars: String, val nSteps: Int)

  fun route(rawGrid: List<String>): Result {
    val grid = mutableMapOf<GridPoint2d, Char>().withDefault { EMPTY_CHAR }

    rawGrid.forEachIndexed { nRow, row ->
      row.forEachIndexed { nCol, value ->
        grid.put(GridPoint2d(nCol, -nRow), value)
      }
    }

    var location = grid.entries.first { it.key.y == 0 && it.value == '|' }.key
    var direction = GridVector2d(0, -1)
    var nSteps = 1
    val letters = mutableListOf<Char>()

    while (true) {
      val char = grid.getValue(location)

      if (char == '+') {
        val directions = setOf(
            GridVector2d( 1,  0),
            GridVector2d( 0,  1),
            GridVector2d( 0, -1),
            GridVector2d(-1,  0)
        ) - direction.`180`()

        // Assume we never terminate at a '+' (valid for given input):
        direction = directions.first { grid.getValue(location + it) != EMPTY_CHAR }
        location += direction
      } else {
        if (char.isLetter()) letters.add(char)

        val nextLocation = location + direction
        if (grid.getValue(nextLocation) == EMPTY_CHAR) {
          return Result(letters.joinToString(""), nSteps)
        } else {
          location = nextLocation
        }
      }

      nSteps += 1
    }
  }

}
