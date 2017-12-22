import NodeState.*

abstract class Virus {

  abstract fun mutate(state: NodeState): NodeState

  fun countInfections(rawMap: List<String>, repeats: Int): Int {
    val initialMap = parseMap(rawMap)
    val currentMap = initialMap.toMutableMap().withDefault { CLEAN }

    var position = GridPoint2d((rawMap.size - 1)/2, -(rawMap.size - 1)/2)
    var direction = GridVector2d(0, 1)

    var count = 0

    repeat(repeats) {
      val currentState = currentMap.getValue(position)

      direction = when (currentState) {
        CLEAN    -> direction.left90()
        WEAKENED -> direction
        INFECTED -> direction.right90()
        FLAGGED  -> direction.`180`()
      }

      val newState = mutate(currentState)
      if (newState == INFECTED) count += 1

      currentMap.put(position, newState)

      position += direction
    }

    return count
  }

  private fun parseMap(rawMap: List<String>): Map<GridPoint2d, NodeState> {
    val result = mutableMapOf<GridPoint2d, NodeState>()

    rawMap.forEachIndexed { rowIndex, row ->
      row.forEachIndexed { colIndex, char ->
        result.put(GridPoint2d(colIndex, -rowIndex), if (char == '#') INFECTED else CLEAN)
      }
    }

    return result
  }

}

class BasicVirus : Virus() {

  override fun mutate(state: NodeState) = when (state) {
    CLEAN    -> INFECTED
    INFECTED -> CLEAN
    else     -> throw IllegalStateException()
  }

}

class EvolvedVirus : Virus() {

  override fun mutate(state: NodeState) = when (state) {
    CLEAN    -> WEAKENED
    WEAKENED -> INFECTED
    INFECTED -> FLAGGED
    FLAGGED  -> CLEAN
  }

}
