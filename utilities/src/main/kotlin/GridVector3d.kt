import kotlin.math.abs

data class GridVector3d(val x: Int, val y: Int, val z: Int) {

  operator fun plus(other: GridVector3d): GridVector3d {
    return GridVector3d(x + other.x, y + other.y, z + other.z)
  }

  val l1Magnitude = abs(x) + abs(y) + abs(z)

}
