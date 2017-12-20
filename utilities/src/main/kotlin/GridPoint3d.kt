import kotlin.math.abs

@Suppress("MemberVisibilityCanPrivate")
data class GridPoint3d(val x: Int, val y: Int, val z: Int) {

  companion object {
    val origin = GridPoint3d(0, 0, 0)
  }

  operator fun plus(other: GridVector3d): GridPoint3d {
    return GridPoint3d(x + other.x, y + other.y, z + other.z)
  }

  fun l1DistanceTo(other: GridPoint3d) = abs(x - other.x) + abs(y - other.y) + abs(z - other.z)

}
