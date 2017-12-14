import java.util.*

typealias Square = GridPoint

class Disk(key: String) {

  private val hasher = KnotHasher()
  private val allUsedSquares: Set<Square>

  init {
    val allUsedSquares = mutableSetOf<Square>()

    (0..127).map { rowNum -> "$key-$rowNum" }
            .map { rowKey -> hasher.hash(rowKey) }
            .map (::rowHashToSquareStrings)
            .forEachIndexed { rowIndex, row ->
              row.forEachIndexed { colIndex, squareString ->
                if (squareString == "1") allUsedSquares.add(Square(rowIndex, colIndex))
              }
            }

    this.allUsedSquares = allUsedSquares
  }

  fun countUsedSquares() = allUsedSquares.size

  fun countGroups(squares: Set<Square> = allUsedSquares): Int {
    if (squares.isEmpty()) return 0

    val squareQueue = ArrayDeque<Square>()
    squareQueue.add(squares.first())

    val visitedSquares = mutableSetOf<Square>()

    while (squareQueue.isNotEmpty()) {
      val currentSquare = squareQueue.pollFirst()

      val groupSquares = currentSquare.neighbors4().filter    { squares.contains(it)        }
                                                   .filterNot { visitedSquares.contains(it) }
                                                   .filter    { it.inBounds(0..127, 0..127) }

      squareQueue.addAll(groupSquares)
      visitedSquares.add(currentSquare)
    }

    return 1 + countGroups(squares - visitedSquares)
  }

  private fun rowHashToSquareStrings(rowHash: String): List<String> {
    return rowHash.chunked(2)
                  .map     { hexPair      -> Integer.parseInt(hexPair, 16)         }
                  .map     { integer      -> integer.toBinaryString(minLength = 8) }
                  .flatMap { binaryString -> binaryString.chunked(1)               }
  }

}
