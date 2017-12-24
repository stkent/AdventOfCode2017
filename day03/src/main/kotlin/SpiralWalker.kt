class SpiralWalker(center: GridPoint2d) {

  var currentGridPoint = center
  private var currentDirection = GridVector2d(0, -1)
  private val visitedPoints = mutableSetOf(currentGridPoint)

  fun step() {
    val pointToLeft = currentGridPoint + currentDirection.left90()
    val visitedPointToLeft = visitedPoints.contains(pointToLeft)

    if (!visitedPointToLeft) {
      currentDirection = currentDirection.left90()
      currentGridPoint = pointToLeft
    } else {
      currentGridPoint += currentDirection
    }

    visitedPoints.add(currentGridPoint)
  }

  fun walk(stepCount: Int) = (1..stepCount).forEach { step() }

}
