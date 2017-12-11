import HexDirection.*
import kotlin.math.abs

// Based on the cube coordinate system: https://www.redblobgames.com/grids/hexagons/#distances-cube
//
//              \ (1, 0, -1) /
//               +----------+
//   (0, 1, -1) /            \ (1, -1, 0)
//            --+              +--
//   (-1, 1, 0) \            / (0, -1, 1)
//               +----------+
//              / (-1, 0, 1) \
//
data class HexGridPoint(private val x: Int, private val y: Int, private val z: Int) {

  fun step(hexDirection: HexDirection) = when (hexDirection) {
    N  -> HexGridPoint(x + 1, y,     z - 1)
    NE -> HexGridPoint(x + 1, y - 1, z    )
    SE -> HexGridPoint(x,     y - 1, z + 1)
    S  -> HexGridPoint(x - 1, y,     z + 1)
    SW -> HexGridPoint(x - 1, y + 1, z    )
    NW -> HexGridPoint(x,     y + 1, z - 1)
  }

  fun distanceTo(other: HexGridPoint) = (abs(x - other.x) + abs(y - other.y) + abs(z - other.z)) / 2

}
