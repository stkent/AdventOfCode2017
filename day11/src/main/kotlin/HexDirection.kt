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
enum class HexDirection {
  N, NE, SE, S, SW, NW;

  companion object {
    fun fromString(string: String): HexDirection? {
      return when (string) {
        "n"  -> N
        "ne" -> NE
        "se" -> SE
        "s"  -> S
        "sw" -> SW
        "nw" -> NW
        else -> null
      }
    }
  }
}
