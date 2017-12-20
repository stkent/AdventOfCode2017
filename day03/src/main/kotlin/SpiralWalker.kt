import Direction.SOUTH

class SpiralWalker(center: GridPoint2d) {

  var currentGridPoint = center
  private var currentDirection = SOUTH
  private val visitedPoints = mutableSetOf(currentGridPoint)

  fun step() {
    val pointToLeft = currentGridPoint.step(currentDirection.turnLeft())
    val visitedPointToLeft = visitedPoints.contains(pointToLeft)

    if (!visitedPointToLeft) {
      currentDirection = currentDirection.turnLeft()
      currentGridPoint = pointToLeft
    } else {
      currentGridPoint = currentGridPoint.step(currentDirection)
    }

    visitedPoints.add(currentGridPoint)
  }

  fun walk(stepCount: Int) = (1..stepCount).forEach { step() }

}
