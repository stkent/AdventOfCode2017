import Direction.*
import kotlin.math.abs
import kotlin.math.hypot

@Suppress("MemberVisibilityCanPrivate", "unused")
data class GridPoint(val x: Int, val y: Int) {

  fun step(direction: Direction) = when (direction) {
    NORTH -> GridPoint(x, y + 1)
    EAST  -> GridPoint(x + 1, y)
    SOUTH -> GridPoint(x, y - 1)
    WEST  -> GridPoint(x - 1, y)
  }

  fun neighbors4(): Set<GridPoint> = setOf(
      GridPoint(x + 1, y),
      GridPoint(x - 1, y),
      GridPoint(x, y + 1),
      GridPoint(x, y - 1)
  )

  fun neighbors8(): Set<GridPoint> = neighbors4().union(setOf(
      GridPoint(x + 1, y + 1),
      GridPoint(x + 1, y - 1),
      GridPoint(x - 1, y - 1),
      GridPoint(x - 1, y + 1)
  ))

  fun l1DistanceTo(target: GridPoint) = abs(x - target.x) + abs(y - target.y)
  fun l2DistanceTo(target: GridPoint) = hypot((x - target.x).toDouble(), (y - target.y).toDouble())

  fun inBounds(
      xBounds: IntRange = Int.MIN_VALUE..Int.MAX_VALUE,
      yBounds: IntRange = Int.MIN_VALUE..Int.MAX_VALUE): Boolean {

    return x in xBounds && y in yBounds
  }

}
