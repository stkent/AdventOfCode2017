data class PathDistances(val end: Int, val max: Int)

class HexGrid {

  fun computeDistances(path: String): PathDistances {
    val origin = HexGridPoint(0, 0, 0)

    val visitedPoints = path.split(',')
        .mapNotNull { HexDirection.fromString(it) }
        .accumulate(origin) { acc, dir -> acc.step(dir) }

    return PathDistances(
        end = visitedPoints.last().distanceTo(origin),
        max = visitedPoints.map { it.distanceTo(origin) }.max()!!)
  }

}
