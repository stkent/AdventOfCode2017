@Suppress("unused")
enum class Direction {

  NORTH,
  EAST,
  SOUTH,
  WEST;

  fun turnLeft() = when (this) {
    NORTH -> WEST
    EAST  -> NORTH
    SOUTH -> EAST
    WEST  -> SOUTH
  }

  fun turnRight() = when (this) {
    NORTH -> EAST
    EAST  -> SOUTH
    SOUTH -> WEST
    WEST  -> NORTH
  }

  fun uTurn() = when (this) {
    NORTH -> SOUTH
    EAST  -> WEST
    SOUTH -> NORTH
    WEST  -> EAST
  }

}
