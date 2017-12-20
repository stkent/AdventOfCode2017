class SpiralMemory {

  private val center = GridPoint2d(0, 0)

  fun getDistanceToAddress(address: Int): Int {
    val spiralWalker = SpiralWalker(center)
    spiralWalker.walk(stepCount = address - 1)
    return spiralWalker.currentGridPoint.l1DistanceTo(center)
  }

  fun getFirstStressTestValueExceeding(threshold: Int): Int {
    val spiralWalker = SpiralWalker(center)
    val visitedPointMap = mutableMapOf(GridPoint2d(0, 0) to 1).withDefault { 0 }

    while (true) {
      spiralWalker.step()
      val currentPoint = spiralWalker.currentGridPoint
      val currentPointValue = currentPoint.neighbors8().sumBy { visitedPointMap.getValue(it) }

      if (currentPointValue > threshold) {
        return currentPointValue
      } else {
        visitedPointMap.put(currentPoint, currentPointValue)
      }
    }
  }

}
