import Main.Direction.E

class Main {

  enum class Direction {
    N, S, E, W;

    fun toLeft() : Direction {
      return when (this) {
        N -> W
        S -> E
        E -> N
        W -> S
      }
    }

    fun gridPointToLeft(point: GridPoint) : GridPoint {
      return when (this) {
        N -> GridPoint(point.first - 1, point.second)
        S -> GridPoint(point.first + 1, point.second)
        E -> GridPoint(point.first, point.second + 1)
        W -> GridPoint(point.first, point.second - 1)
      }
    }

    fun gridPointInFront(point: GridPoint) : GridPoint {
      return when (this) {
        N -> GridPoint(point.first, point.second + 1)
        S -> GridPoint(point.first, point.second - 1)
        E -> GridPoint(point.first + 1, point.second)
        W -> GridPoint(point.first - 1, point.second)
      }
    }
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
//      val input = 277678
//
//      val visitedPoints = mutableSetOf(GridPoint(0, 0))
//      var currentPoint = GridPoint(1, 0)
//      var currentDirection = E
//
//      for (i in 2 until input) {
//        visitedPoints.add(currentPoint)
//
//        if (visitedPoints.contains(currentDirection.gridPointToLeft(currentPoint))) {
//          currentPoint = currentDirection.gridPointInFront(currentPoint)
//        } else {
//          currentPoint = currentDirection.gridPointToLeft(currentPoint)
//          currentDirection = currentDirection.toLeft()
//        }
//
//        println(currentPoint)
//      }
//
//      println(currentPoint.l1DistanceFrom(GridPoint(0, 0)))

      val input = 277678

      val visitedPointValues = mutableMapOf(GridPoint(0, 0) to 1)
      var currentPoint = GridPoint(1, 0)
      var currentDirection = E

      while (visitedPointValues.values.max()!! < input) {
        val pointValue = currentPoint.neighbors8()
          .filter { visitedPointValues.containsKey(it) }
          .sumBy { visitedPointValues[it]!! }

        visitedPointValues.put(currentPoint, pointValue)

        if (visitedPointValues.keys.contains(currentDirection.gridPointToLeft(currentPoint))) {
          currentPoint = currentDirection.gridPointInFront(currentPoint)
        } else {
          currentPoint = currentDirection.gridPointToLeft(currentPoint)
          currentDirection = currentDirection.toLeft()
        }
      }

      println(visitedPointValues.values.max()!!)
    }
  }

}
