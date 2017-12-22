import kotlin.math.abs

data class GridVector2d(val x: Int, val y: Int) {

  operator fun plus(other: GridVector2d): GridVector2d {
    return GridVector2d(x + other.x, y + other.y)
  }

  fun left90() = GridVector2d(-y, x)

  fun right90() = GridVector2d(y, -x)

  fun `180`() = GridVector2d(-x, -y)

  val l1Magnitude = abs(x) + abs(y)

}
